package dev.finalproject.database;


import dev.finalproject.data.AddressDAO;
import dev.finalproject.data.AttendanceLogDAO;
import dev.finalproject.data.AttendanceRecordDAO;
import dev.finalproject.data.ClusterDAO;
import dev.finalproject.data.GuardianDAO;
import dev.finalproject.data.SchoolYearDAO;
import dev.finalproject.data.StudentDAO;
import dev.finalproject.data.StudentGuardianDAO;
import dev.sol.core.registry.FXCollectionsRegister;
import javafx.collections.FXCollections;

/**
 * DataManager is a singleton responsible for initializing and managing
 * the dataset collections used throughout the application.
 */
public final class DataManager {

    private static volatile DataManager instance;
    private final FXCollectionsRegister collectionsRegistry;

    // Private constructor to enforce singleton
    private DataManager() {
        this.collectionsRegistry = FXCollectionsRegister.INSTANCE;
    }

    /**
     * Returns the singleton instance of DataManager.
     *
     * @return the DataManager instance.
     */
    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager();
                }
            }
        }
        return instance;
    }

    /**
     * Returns the FXCollectionsRegister used for storing collections.
     *
     * @return the FXCollectionsRegister instance.
     */
    public FXCollectionsRegister getCollectionsRegistry() {
        return collectionsRegistry;
    }

    /**
     * Initializes the data collections by loading data from the database.
     */
    public void initializeData() {
        try {
            // Initialize basic collections first
            collectionsRegistry.register("CLUSTER",
                    FXCollections.observableArrayList(ClusterDAO.getClusterList()));

            collectionsRegistry.register("SCHOOL_YEAR",
                    FXCollections.observableArrayList(SchoolYearDAO.getSchoolYearList()));

            collectionsRegistry.register("GUARDIAN",
                    FXCollections.observableArrayList(GuardianDAO.getGuardianList()));

            // Initialize student-related collections
            StudentDAO.initialize(
                    collectionsRegistry.getList("CLUSTER"),
                    collectionsRegistry.getList("SCHOOL_YEAR"));
            collectionsRegistry.register("STUDENT",
                    FXCollections.observableArrayList(StudentDAO.getStudentList()));

            collectionsRegistry.register("STUDENT_GUARDIAN",
                    FXCollections.observableArrayList(StudentGuardianDAO.getStudentGuardianList()));

            // Initialize address after student
            AddressDAO.initialize(collectionsRegistry.getList("STUDENT"));
            collectionsRegistry.register("ADDRESS",
                    FXCollections.observableArrayList(AddressDAO.getAddressesList()));

            // Initialize attendance records
            collectionsRegistry.register("ATTENDANCE_RECORD",
                    FXCollections.observableArrayList(AttendanceRecordDAO.getRecordList()));

            // Initialize attendance logs last, after both student and attendance records are ready
            collectionsRegistry.register("ATTENDANCE_LOG",
                    FXCollections.observableArrayList()); // Create empty list first

            AttendanceLogDAO.initialize(
                    collectionsRegistry.getList("STUDENT"),
                    collectionsRegistry.getList("ATTENDANCE_RECORD"));

            // Populate the attendance log list
            collectionsRegistry.getList("ATTENDANCE_LOG").addAll(AttendanceLogDAO.getAttendanceLogList());

        } catch (Exception e) {
            System.err.println("Error initializing datasets: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize application data", e);
        }
    }
}