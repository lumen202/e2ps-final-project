package dev.finalproject.app;

import dev.finalproject.App;
import dev.sol.core.application.loader.FXLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RootLoader extends FXLoader {

    private FXMLLoader loader;
    private Parent root;

    @Override
    public void load() {
        try {
            loader = new FXMLLoader(getClass().getResource("/dev/finalproject/app/ROOT.fxml"));
            root = loader.load();
            Scene scene = (Scene) params.get("scene");
            scene.setRoot(root);

            RootController controller = loader.getController();
            App.CONTROLLER_REGISTRY.register("ROOT", controller);
            controller.addParameter("SCENE", scene).load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
