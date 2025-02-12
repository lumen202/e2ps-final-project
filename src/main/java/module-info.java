module dev.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires core.fx;
    requires core.db;
    requires core.util;

    opens dev.finalproject to javafx.fxml;
    exports dev.finalproject;
}
