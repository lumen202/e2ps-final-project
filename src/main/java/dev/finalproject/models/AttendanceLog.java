package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;

public class AttendanceLog extends FXModel {

    private FXIntegerProperty log_ID;
    private FXIntegerProperty month;
    private FXIntegerProperty day;
    private FXIntegerProperty year;

    public AttendanceLog(int log_ID, int month, int day, int year) {
        this.log_ID = new FXIntegerProperty(log_ID);
        this.month = new FXIntegerProperty(month);
        this.day = new FXIntegerProperty(day);
        this.year = new FXIntegerProperty(year);
    }

    // Property
    public FXIntegerProperty logIDProperty() {
        return this.log_ID;
    }

    public FXIntegerProperty monthProperty() {
        return this.month;
    }

    public FXIntegerProperty dayProperty() {
        return this.day;
    }

    public FXIntegerProperty yearProperty() {
        return this.year;
    }

    // Gatters and Setters
    public int getLog_ID() {
        return this.logIDProperty().get();
    }

    public void setLog_ID(int log_ID) {
        logIDProperty().set(log_ID);
    }

    public int getMonth() {
        return this.monthProperty().get();
    }

    public void setMonth(int month) {
        monthProperty().set(month);
    }
    public int getDay(){
        return this.dayProperty().get();
    }
    public void setDay(int day){
        dayProperty().set(day);
    }
    public int getYear(){
        return this.yearProperty().get();
    }
    public void setYear(int year){
        yearProperty().set(year);
    }

    @Override
    public FXModel clone() {
       AttendanceLog attendanceLog = new AttendanceLog(getLog_ID(), getMonth(), getDay(), getYear());
       return attendanceLog;
    }

    @Override
    public void copy(FXModel arg0) {
       AttendanceLog c = (AttendanceLog) arg0;
       setLog_ID(c.getLog_ID());
       setMonth(c.getMonth());
       setDay(c.getDay());
       setYear(c.getYear());

    }

}
