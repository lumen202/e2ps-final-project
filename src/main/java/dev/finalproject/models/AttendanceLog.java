package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;

public class AttendanceLog extends FXModel {

    private FXObjectProperty<AttendanceRecord> log_ID;
    private FXIntegerProperty month;
    private FXIntegerProperty day;
    private FXIntegerProperty year;

    public AttendanceLog(AttendanceRecord log_ID, int month, int day, int year) {
        this.log_ID = new FXObjectProperty<AttendanceRecord>(log_ID);
        this.month = new FXIntegerProperty(month);
        this.day = new FXIntegerProperty(day);
        this.year = new FXIntegerProperty(year);
    }

    // Property
    public FXObjectProperty<AttendanceRecord> logIDProperty() {
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
    public AttendanceRecord getLog_ID() {
        return this.logIDProperty().get();
    }

    public void setLog_ID(AttendanceRecord log_ID) {
        logIDProperty().set(log_ID);
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
        AttendanceLog attendanceLog = new AttendanceLog(this.log_ID.get(), this.getMonth(), this.getDay(),
                this.getYear());
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