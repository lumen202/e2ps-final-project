package dev.finalproject;

import dev.finalproject.app.RootLoader;
import dev.finalproject.data.AddressDAO;
import dev.finalproject.data.AttendanceLogDAO;
import dev.finalproject.data.AttendanceRecordDAO;
import dev.finalproject.data.ClusterDAO;
import dev.finalproject.data.GuardianDAO;
import dev.finalproject.data.SchoolYearDAO;
import dev.finalproject.data.StudentDAO;
import dev.finalproject.data.StudentGuardianDAO;
import dev.sol.core.application.FXApplication;
import dev.sol.core.application.loader.FXLoaderFactory;
import dev.sol.core.registry.FXCollectionsRegister;
import dev.sol.core.registry.FXControllerRegister;
import dev.sol.core.registry.FXNodeRegister;
import dev.sol.core.scene.FXSkin;
import dev.sol.db.DBService;
import javafx.collections.FXCollections;

public class App extends FXApplication {

        public static final String remoteHost = "jdbc:mysql://192.168.254.108:3306/student_management_system_db?user=root&password=admin&allowPublicKeyRetrieval=true&useSSL=false";
        public static final String localHost = "jdbc:mysql://localhost:3306/student_management_system_db?user=root&password=admin&allowPublicKeyRetrieval=true&useSSL=false";

        public static final FXControllerRegister CONTROLLER_REGISTRY = FXControllerRegister.INSTANCE;
        public static final FXCollectionsRegister COLLECTIONS_REGISTRY = FXCollectionsRegister.INSTANCE;
        public static final FXNodeRegister NODE_REGISTER = FXNodeRegister.INSTANCE;

        public static final DBService DB_SMS = DBService.INSTANCE
                        .initialize(localHost);
        @Override
        public void initialize() throws Exception {
                setTitle("Student Management System");
                setSkin(FXSkin.PRIMER_LIGHT);
                applicationStage.setResizable(false);
                applicationStage.getOnCloseRequest();

                // initialize_dataset();
                initialize_application();
        }

        public void initialize_dataset() {
                try {
                        // Initialize basic collections first
                        COLLECTIONS_REGISTRY.register("CLUSTER",
                                        FXCollections.observableArrayList(ClusterDAO.getClusterList()));

                        COLLECTIONS_REGISTRY.register("SCHOOL_YEAR",
                                        FXCollections.observableArrayList(SchoolYearDAO.getSchoolYearList()));

                        COLLECTIONS_REGISTRY.register("GUARDIAN",
                                        FXCollections.observableArrayList(GuardianDAO.getGuardianList()));

                        // Initialize student-related collections
                        StudentDAO.initialize(
                                        COLLECTIONS_REGISTRY.getList("CLUSTER"),
                                        COLLECTIONS_REGISTRY.getList("SCHOOL_YEAR"));
                        COLLECTIONS_REGISTRY.register("STUDENT",
                                        FXCollections.observableArrayList(StudentDAO.getStudentList()));

                        COLLECTIONS_REGISTRY.register("STUDENT_GUARDIAN",
                                        FXCollections.observableArrayList(StudentGuardianDAO.getStudentGuardianList()));

                        // Initialize address after student
                        AddressDAO.initialize(COLLECTIONS_REGISTRY.getList("STUDENT"));
                        COLLECTIONS_REGISTRY.register("ADDRESS",
                                        FXCollections.observableArrayList(AddressDAO.getAddressesList()));

                        // Initialize attendance records
                        COLLECTIONS_REGISTRY.register("ATTENDANCE_RECORD",
                                        FXCollections.observableArrayList(AttendanceRecordDAO.getRecordList()));

                        // Initialize attendance logs last, after both student and attendance records are ready
                        COLLECTIONS_REGISTRY.register("ATTENDANCE_LOG",
                                        FXCollections.observableArrayList()); // Create empty list first

                        AttendanceLogDAO.initialize(
                                        COLLECTIONS_REGISTRY.getList("STUDENT"),
                                        COLLECTIONS_REGISTRY.getList("ATTENDANCE_RECORD")); // Changed from ATTENDANCE_LOG to ATTENDANCE_RECORD

                        // Now populate the attendance log list
                        COLLECTIONS_REGISTRY.getList("ATTENDANCE_LOG").addAll(AttendanceLogDAO.getAttendanceLogList());

                } catch (Exception e) {
                        System.err.println("Error initializing datasets: " + e.getMessage());
                        e.printStackTrace();
                        throw new RuntimeException("Failed to initialize application data", e);
                }
        }

        private void initialize_application() {
                RootLoader rootLoader = (RootLoader) FXLoaderFactory
                                .createInstance(RootLoader.class,
                                                App.class.getResource("/dev/finalproject/app/ROOT.fxml"))
                                .addParameter("scene", applicationScene).initialize();
                rootLoader.load();
        }

}