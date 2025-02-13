package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;

public class AttendanceRecord extends FXModel {

    private FXIntegerProperty recordID;
    private FXObjectProperty<AttendanceLog> logID;
    private FXObjectProperty<Student> studentID;
    private FXIntegerProperty timeInAM;
    private FXIntegerProperty timeInPM;
    private FXIntegerProperty timeOutAM;
    private FXIntegerProperty timeOutPM;

    public AttendanceRecord(int recordID, AttendanceLog logID, Student studentID, int timeInAM, int timeInPM,
            int timeOutAM,
            int timeOutPM) {
        this.recordID = new FXIntegerProperty(recordID);
        this.logID = new FXObjectProperty<AttendanceLog>(logID);
        this.studentID = new FXObjectProperty<Student>(studentID);
        this.timeInAM = new FXIntegerProperty(timeInAM);
        this.timeInPM = new FXIntegerProperty(timeInPM);
        this.timeOutAM = new FXIntegerProperty(timeOutAM);
        this.timeOutPM = new FXIntegerProperty(timeOutPM);
    }

    // Property Methods
    public FXIntegerProperty recordIDProperty() {
        return recordID;
    }

    public FXObjectProperty<AttendanceLog> logIDProperty() {
        return logID;
    }

    public FXObjectProperty<Student> studentIDProperty() {
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

    public AttendanceLog getLogID() {
        return logID.get();
    }

    public Student getStudentID() {
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

    public void setLogID(AttendanceLog logID) {
        this.logID.set(logID);
    }

    public void setStudentID(Student studentID) {
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
        return new AttendanceRecord(getRecordID(),
                getLogID(),
                getStudentID(),
                getTimeInAM(),
                getTimeInPM(),
                getTimeOutAM(),
                getTimeOutPM());
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