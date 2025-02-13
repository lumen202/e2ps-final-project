package dev.finalproject;

import dev.finalproject.data.AddressDAO;
import dev.finalproject.data.AttendanceLogDAO;
import dev.finalproject.data.AttendanceRecordDAO;
import dev.finalproject.data.ClusterDAO;
import dev.finalproject.data.GuardianDAO;
import dev.finalproject.data.StudentDAO;
import dev.finalproject.data.StudentGuardianDAO;
import dev.sol.core.application.FXApplication;
import dev.sol.core.registry.FXCollectionsRegister;
import dev.sol.core.registry.FXControllerRegister;
import dev.sol.core.registry.FXNodeRegister;
import dev.sol.core.scene.FXSkin;
import dev.sol.db.DBService;
import javafx.collections.FXCollections;

public class App extends FXApplication {
    public static final FXControllerRegister CONTROLLER_REGISTRY = FXControllerRegister.INSTANCE;
    public static final FXCollectionsRegister COLLECTIONS_REGISTRY = FXCollectionsRegister.INSTANCE;
    public static final FXNodeRegister NODE_REGISTER = FXNodeRegister.INSTANCE;

    public static final DBService DB_SMS = DBService.INSTANCE
            .initialize("jdbc:mysql://localhost/student_management_system?user=root&password=");

    @Override
    public void initialize() throws Exception {
        setTitle("Student Management System");
        setSkin(FXSkin.PRIMER_LIGHT);
        applicationStage.setResizable(false);
        applicationStage.getOnCloseRequest();

        initialize_dataset();
    }

    public void initialize_dataset() {
        COLLECTIONS_REGISTRY.register("ADDRESS",
                FXCollections.observableArrayList(AddressDAO.getAddressesList()));
        COLLECTIONS_REGISTRY.register("ATTENDANCE_LOG",
                FXCollections.observableArrayList(AttendanceLogDAO.getLogList()));
        COLLECTIONS_REGISTRY.register("ATTENDANCE_RECORD",
                FXCollections.observableArrayList(AttendanceRecordDAO.getAttendanceRecordList()));
        COLLECTIONS_REGISTRY.register("CLUSTER",
                FXCollections.observableArrayList(ClusterDAO.getClusterList()));
        COLLECTIONS_REGISTRY.register("GUARDIAN",
                FXCollections.observableArrayList(GuardianDAO.getGuardianList()));
        COLLECTIONS_REGISTRY.register("STUDENT",
                FXCollections.observableArrayList(StudentDAO.getStudentList()));
        COLLECTIONS_REGISTRY.register("STUDENT_GUARDIAN",
                FXCollections.observableArrayList(StudentGuardianDAO.getStudentGuardianList()));

    }

}