package dev.finalproject.app;

import dev.finalproject.App;
import dev.finalproject.models.AttendanceLog;
import dev.finalproject.models.Cluster;
import dev.finalproject.models.Student;
import dev.sol.core.application.FXController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RootController extends FXController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button getStartedButton;

    private ObservableList<Student> studentList;
    private ObservableList<AttendanceLog> recordList;

    private ObservableList<Cluster> clusterList;

    @Override
    protected void load_bindings() {
        studentList = App.COLLECTIONS_REGISTRY.getList("STUDENT");
        recordList = App.COLLECTIONS_REGISTRY.getList("ATTENDANCE_RECORD");
        clusterList = App.COLLECTIONS_REGISTRY.getList("CLUSTER");


        System.out.println("Cluster List: " + clusterList);
        System.out.println("Record list: " + recordList);
        System.out.println("Student list: " + studentList);
    
    }

    @Override
    protected void load_fields() {
        // Initialize fields if necessary
    }

    @Override
    protected void load_listeners() {
        getStartedButton.setOnAction(event -> {
            // Handle button click event
            System.out.println("Get Started button clicked!");
        });
    }
}
