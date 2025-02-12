package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;

public class AttendanceRecord extends FXModel {

    private FXIntegerProperty recordID;
    private FXIntegerProperty logID;
    private FXIntegerProperty studentID;
    private FXIntegerProperty timeInAM;
    private FXIntegerProperty timeInPM;
    private FXIntegerProperty timeOutAM;
    private FXIntegerProperty timeOutPM;

    public AttendanceRecord(int recordID, int logID, int studentID, int timeInAM, int timeInPM, int timeOutAM,
            int timeOutPM) {
        this.recordID = new FXIntegerProperty(recordID);
        this.logID = new FXIntegerProperty(logID);
        this.studentID = new FXIntegerProperty(studentID);
        this.timeInAM = new FXIntegerProperty(timeInAM);
        this.timeInPM = new FXIntegerProperty(timeInPM);
        this.timeOutAM = new FXIntegerProperty(timeOutAM);
        this.timeOutPM = new FXIntegerProperty(timeOutPM);
    }

    // Property Methods
    public FXIntegerProperty recordIDProperty() {
        return recordID;
    }

    public FXIntegerProperty logIDProperty() {
        return logID;
    }

    public FXIntegerProperty studentIDProperty() {
        return studentID;
    }

    public FXIntegerProperty timeInAMProperty() {
        return timeInAM;
    }

    public FXIntegerProperty timeInPMProperty() {
        return timeInPM;
    }

    public FXIntegerProperty timeOutAMProperty() {
        return timeOutAM;
    }

    public FXIntegerProperty timeOutPMProperty() {
        return timeOutPM;
    }

    // Getters
    public int getRecordID() {
        return recordID.get();
    }

    public int getLogID() {
        return logID.get();
    }

    public int getStudentID() {
        return studentID.get();
    }

    public int getTimeInAM() {
        return timeInAM.get();
    }

    public int getTimeInPM() {
        return timeInPM.get();
    }

    public int getTimeOutAM() {
        return timeOutAM.get();
    }

    public int getTimeOutPM() {
        return timeOutPM.get();
    }

    // Setters
    public void setRecordID(int recordID) {
        this.recordID.set(recordID);
    }

    public void setLogID(int logID) {
        this.logID.set(logID);
    }

    public void setStudentID(int studentID) {
        this.studentID.set(studentID);
    }

    public void setTimeInAM(int timeInAM) {
        this.timeInAM.set(timeInAM);
    }

    public void setTimeInPM(int timeInPM) {
        this.timeInPM.set(timeInPM);
    }

    public void setTimeOutAM(int timeOutAM) {
        this.timeOutAM.set(timeOutAM);
    }

    public void setTimeOutPM(int timeOutPM) {
        this.timeOutPM.set(timeOutPM);
    }

    @Override
    public FXModel clone() {
        return new AttendanceRecord(getRecordID(), getLogID(), getStudentID(), getTimeInAM(), getTimeInPM(),
                getTimeOutAM(), getTimeOutPM());
    }

    @Override
    public void copy(FXModel model) {
        if (model instanceof AttendanceRecord other) {
            setRecordID(other.getRecordID());
            setLogID(other.getLogID());
            setStudentID(other.getStudentID());
            setTimeInAM(other.getTimeInAM());
            setTimeInPM(other.getTimeInPM());
            setTimeOutAM(other.getTimeOutAM());
            setTimeOutPM(other.getTimeOutPM());
        }
    }
}