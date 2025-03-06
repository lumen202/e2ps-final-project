package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;

public class AttendanceRecord extends FXModel {

    private FXIntegerProperty recordID;
    private FXIntegerProperty month;
    private FXIntegerProperty day;
    private FXIntegerProperty year;

    public AttendanceRecord(int recordID, int month, int day, int year) {
        this.recordID = new FXIntegerProperty(recordID);
        this.month = new FXIntegerProperty(month);
        this.day = new FXIntegerProperty(day);
        this.year = new FXIntegerProperty(year);
    }

    // Property
    public FXIntegerProperty recordIDProperty() {
        return this.recordID;
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

    // Getters and Setters

    public int getRecordID() {
        return this.recordIDProperty().get();
    }

    public void setRecordID(int recordID) {
        recordIDProperty().set(recordID);
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
        AttendanceRecord attendanceRecord = new AttendanceRecord(this.getRecordID(), this.getMonth(), this.getDay(),
                this.getYear());
        return attendanceRecord;
    }

    @Override
    public void copy(FXModel arg0) {
        AttendanceRecord c = (AttendanceRecord) arg0;
        setRecordID(c.getRecordID());
        setMonth(c.getMonth());
        setDay(c.getDay());
        setYear(c.getYear());

    }

}