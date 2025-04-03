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
 * DataManager is a singleton responsible for initializing and managing the
 * dataset collections used throughout the application.
 *
 * In this version, we have removed any DAO.initialize() calls. Instead, the
 * shared collections are directly rebuilt by fetching fresh data via DAO calls.
 */
public final class DataManager {

    private static volatile DataManager instance;
    private final FXCollectionsRegister collectionsRegistry;

    // Private constructor to enforce singleton usage.
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
     * Initializes or refreshes the data collections by loading fresh data from
     * the database and re-registering new ObservableList instances.
     */
    public void initializeData() {
        try {
            // Create new ObservableList instances for each collection from fresh DAO calls.
            collectionsRegistry.register("CLUSTER",
                    FXCollections.observableArrayList(ClusterDAO.getClusterList()));

            collectionsRegistry.register("SCHOOL_YEAR",
                    FXCollections.observableArrayList(SchoolYearDAO.getSchoolYearList()));

            collectionsRegistry.register("GUARDIAN",
                    FXCollections.observableArrayList(GuardianDAO.getGuardianList()));

            collectionsRegistry.register("STUDENT",
                    FXCollections.observableArrayList(StudentDAO.getStudentList()));

            collectionsRegistry.register("STUDENT_GUARDIAN",
                    FXCollections.observableArrayList(StudentGuardianDAO.getStudentGuardianList()));

            collectionsRegistry.register("ADDRESS",
                    FXCollections.observableArrayList(AddressDAO.getAddressesList()));

            collectionsRegistry.register("ATTENDANCE_RECORD",
                    FXCollections.observableArrayList(AttendanceRecordDAO.getRecordList()));

            collectionsRegistry.register("ATTENDANCE_LOG",
                    FXCollections.observableArrayList(AttendanceLogDAO.getAttendanceLogList()));

        } catch (Exception e) {
            System.err.println("Error initializing datasets: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize application data", e);
        }
    }

    /**
     * Refreshes all data by reloading from the database.
     */
    public void refreshData() {
        initializeData();
    }
}
