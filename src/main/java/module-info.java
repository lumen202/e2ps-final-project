module dev.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires core.fx;

    opens dev.finalproject to javafx.fxml;

    exports dev.finalproject;
}
