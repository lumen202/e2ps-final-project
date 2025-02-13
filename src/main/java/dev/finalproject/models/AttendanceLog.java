package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;

public class AttendanceLog extends FXModel {

    private FXIntegerProperty logID;
    private FXIntegerProperty month;
    private FXIntegerProperty day;
    private FXIntegerProperty year;

    public AttendanceLog(int logID, int month, int day, int year) {
        this.logID = new FXIntegerProperty(logID);
        this.month = new FXIntegerProperty(month);
        this.day = new FXIntegerProperty(day);
        this.year = new FXIntegerProperty(year);
    }

    // Property
    public FXIntegerProperty logIDProperty() {
        return this.logID;
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

    public int getLogID() {
        return this.logIDProperty().get();
    }

    public void setLogID(int logID) {
        logIDProperty().set(logID);
    }

    public int getMonth() {
        return this.monthProperty().get();
    }

    public void setMonth(int month) {
        monthProperty().set(month);
    }

    public int getDay() {
        return this.dayProperty().get();
    }

    public void setDay(int day) {
        dayProperty().set(day);
    }

    public int getYear() {
        return this.yearProperty().get();
    }

    public void setYear(int year) {
        yearProperty().set(year);
    }

    @Override
    public FXModel clone() {
        AttendanceLog attendanceLog = new AttendanceLog(this.getLogID(), this.getMonth(), this.getDay(),
                this.getYear());
        return attendanceLog;
    }

    @Override
    public void copy(FXModel arg0) {
        AttendanceLog c = (AttendanceLog) arg0;
        setLogID(c.getLogID());
        setMonth(c.getMonth());
        setDay(c.getDay());
        setYear(c.getYear());

    }

}