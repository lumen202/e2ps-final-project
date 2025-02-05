module dev.finalproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens dev.finalproject to javafx.fxml;
    exports dev.finalproject;
}
