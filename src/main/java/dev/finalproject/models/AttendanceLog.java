package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;

public class AttendanceLog extends FXModel {

    private FXIntegerProperty logID;
    private FXObjectProperty<AttendanceRecord> recorID;
    private FXObjectProperty<Student> studentID;
    private FXIntegerProperty timeInAM;
    private FXIntegerProperty timeInPM;
    private FXIntegerProperty timeOutAM;
    private FXIntegerProperty timeOutPM;

    public AttendanceLog(int logID, AttendanceRecord recordID, Student studentID, int timeInAM, int timeInPM,
            int timeOutAM,
            int timeOutPM) {
        this.logID = new FXIntegerProperty(logID);
        this.recorID = new FXObjectProperty<AttendanceRecord>(recordID);
        this.studentID = new FXObjectProperty<Student>(studentID);
        this.timeInAM = new FXIntegerProperty(timeInAM);
        this.timeInPM = new FXIntegerProperty(timeInPM);
        this.timeOutAM = new FXIntegerProperty(timeOutAM);
        this.timeOutPM = new FXIntegerProperty(timeOutPM);
    }

    public AttendanceLog(Student studentID, AttendanceRecord recordID) {
        this.logID = new FXIntegerProperty(0); // Default to 0, will be set by database
        this.recorID = new FXObjectProperty<AttendanceRecord>(recordID);
        this.studentID = new FXObjectProperty<Student>(studentID);
        this.timeInAM = new FXIntegerProperty(0);
        this.timeInPM = new FXIntegerProperty(0);
        this.timeOutAM = new FXIntegerProperty(0);
        this.timeOutPM = new FXIntegerProperty(0);
    }

    // Property Methods
    public FXIntegerProperty logIDProperty() {
        return logID;
    }

    public FXObjectProperty<AttendanceRecord> recordIDProperty() {
        return recorID;
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
    public int getLogID() {
        return logID.get();
    }

    public AttendanceRecord getRecordID() {
        return recorID.get();
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
    public void setLogID(int logID) {
        this.logID.set(logID);
    }

    public void setrecordID(AttendanceRecord recordID) {
        this.recorID.set(recordID);
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
        return new AttendanceLog(getLogID(), getRecordID(), getStudentID(), getTimeInAM(), getTimeInPM(),
                getTimeOutAM(), getTimeOutPM());
    }

    @Override
    public void copy(FXModel model) {
        if (model instanceof AttendanceLog other) {
            setLogID(getLogID());
            setrecordID(getRecordID());
            setStudentID(other.getStudentID());
            setTimeInAM(other.getTimeInAM());
            setTimeInPM(other.getTimeInPM());
            setTimeOutAM(other.getTimeOutAM());
            setTimeOutPM(other.getTimeOutPM());
        }
    }
}