package dev.finalproject;

import dev.finalproject.app.RootLoader;
import dev.finalproject.database.DataManager;
import dev.sol.core.application.FXApplication;
import dev.sol.core.application.loader.FXLoaderFactory;
import dev.sol.core.registry.FXCollectionsRegister;
import dev.sol.core.registry.FXControllerRegister;
import dev.sol.core.registry.FXNodeRegister;
import dev.sol.core.scene.FXSkin;
import dev.sol.db.DBService;

public class App extends FXApplication {

    public static final String REMOTE_HOST = "jdbc:mysql://192.168.254.108:3306/student_management_system_db?user=root&password=admin&allowPublicKeyRetrieval=true&useSSL=false";
    public static final String LOCAL_HOST = "jdbc:mysql://localhost/student_management_system_db?user=root&password=admin";
    public static final String LAB_HOST = "jdbc:mysql://192.168.254.108:3306/student_management_system_db?user=remote_user&allowPublicKeyRetrieval=true&useSSL=false";

    public static final FXControllerRegister CONTROLLER_REGISTRY = FXControllerRegister.INSTANCE;
    public static final FXCollectionsRegister COLLECTIONS_REGISTRY = FXCollectionsRegister.INSTANCE;
    public static final FXNodeRegister NODE_REGISTER = FXNodeRegister.INSTANCE;

    public static final DBService DB_SMS = DBService.INSTANCE
            .initialize(LAB_HOST);

    @Override
    public void initialize() throws Exception {
        setTitle("Student Management System");
        setSkin(FXSkin.PRIMER_LIGHT);
        applicationStage.setResizable(false);
        applicationStage.getOnCloseRequest();

        // Use the DataManager singleton to initialize the dataset
        DataManager.getInstance().initializeData();

        initialize_application();
    }

    private void initialize_application() {
        RootLoader rootLoader = (RootLoader) FXLoaderFactory
                .createInstance(RootLoader.class,
                        App.class.getResource("/dev/finalproject/app/ROOT.fxml"))
                .addParameter("scene", applicationScene)
                .initialize();
        rootLoader.load();
    }
}
