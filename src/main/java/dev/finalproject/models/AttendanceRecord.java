package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;

public class AttendanceRecord extends FXModel {

    private FXIntegerProperty record_ID;
    private FXIntegerProperty log_ID;
    private FXIntegerProperty student_ID;
    private FXIntegerProperty time_in_am;
    private FXIntegerProperty time_in_pm;
    private FXIntegerProperty time_out_am;
    private FXIntegerProperty time_out_pm;

    public AttendanceRecord(int record_ID, int log_ID, int student_ID, int time_in_am, int time_in_pm, int time_out_am, int time_out_pm){
        this.record_ID = new FXIntegerProperty(record_ID);
        this.log_ID = new FXIntegerProperty(log_ID);
        this.student_ID = new FXIntegerProperty(student_ID);
        this.time_in_am = new FXIntegerProperty(time_in_am);
        this.time_in_pm = new FXIntegerProperty(time_in_pm);
        this.time_out_am = new FXIntegerProperty(time_out_am);
        this.time_out_pm = new FXIntegerProperty(time_out_pm);

    }
    // Property
    public FXIntegerProperty record_IDProperty(){
        return this.record_ID;
    }
    public FXIntegerProperty log_IDProperty(){
        return this.log_ID;
    }
    
    public FXIntegerProperty student_IDProperty() {
        return this.student_ID;
    }
    
    public FXIntegerProperty time_in_amProperty() {
        return this.time_in_am;
    }
    
    public FXIntegerProperty time_in_pmProperty() {
        return this.time_in_pm;
    }
    
    public FXIntegerProperty time_out_amProperty() {
        return this.time_out_am;
    }
    
    public FXIntegerProperty time_out_pmProperty() {
        return this.time_out_pm;
    }
    // Gatters 
    public int getRecord_ID(){
        return this.record_IDProperty().get();
    }
    
    public int getLog_ID() {
        return this.log_IDProperty().get();
    }
    
    public int getStudent_ID() {
        return this.student_IDProperty().get();
    }
    
    public int getTime_in_Am() {
        return this.time_in_amProperty().get();
    }
    
    public int getTime_in_Pm() {
        return this.time_in_pmProperty().get();
    }
    
    public int getTime_Out_Am() {
        return this.time_out_amProperty().get();
    }
    
    public int getTime_Out_Pm() {
        return this.time_out_pmProperty().get();
    }
    // Setters 
    public void setRecord_ID(int record_ID){
        record_IDProperty().set(record_ID);
    }
    public void setLog_ID(int log_ID){
        log_IDProperty().set(log_ID);
    }
    public void setStudent_ID(int student_ID){
        student_IDProperty().set(student_ID);
    }
    public void setTime_In_Am(int time_in_am){
        time_in_amProperty().set(time_in_am);
    }
    public void setTime_In_Pm(int time_in_pm){
        time_in_pmProperty().set(time_in_pm);
    }
    
    public void setTime_Out_Am(int time_out_am) {
        time_out_amProperty().set(time_out_am);
    }

    public void setTime_Out_Pm(int time_out_pm) {
        time_out_pmProperty().set(time_out_pm);
    }


    @Override
    public FXModel clone() {
        AttendanceRecord attendanceRecord = new AttendanceRecord(getRecord_ID(), getLog_ID(), getStudent_ID(), getTime_in_Am(), getTime_in_Pm(), getTime_Out_Am(), getTime_Out_Pm());
        return attendanceRecord;
    }

    @Override
    public void copy(FXModel arg0) {
       AttendanceRecord c = (AttendanceRecord) arg0;
       setRecord_ID(c.getRecord_ID());
       setLog_ID(c.getLog_ID());
       setStudent_ID(c.getStudent_ID());
       setTime_In_Am(c.getTime_in_Am());
       setTime_In_Pm(c.getTime_in_Pm());
       setTime_Out_Am(c.getTime_Out_Am());
       setTime_Out_Pm(c.getTime_Out_Pm());
    }

}
