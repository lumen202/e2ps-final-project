module dev.finalproject {

    requires transitive javafx.controls;
    requires transitive core.fx;
    requires javafx.fxml;
    requires atlantafx.base;
    requires javafx.graphics;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires org.kordamp.ikonli.materialdesign;

    requires transitive core.db;
    requires core.util;
    requires java.sql.rowset;
    requires javafx.base;

    opens dev.finalproject to javafx.fxml;
    opens dev.finalproject.app to javafx.fxml;

    exports dev.finalproject;
    exports dev.finalproject.models;
    exports dev.finalproject.data;
    exports dev.finalproject.app;

}
