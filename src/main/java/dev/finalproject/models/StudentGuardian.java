package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXObjectProperty;

public class StudentGuardian extends FXModel {

    private FXObjectProperty<Student> studentId;
    private FXObjectProperty<Guardian> guardianId;

    public StudentGuardian(Student studentId, Guardian guardianId) {
        this.studentId = new FXObjectProperty<Student>(studentId);
        this.guardianId = new FXObjectProperty<Guardian>(guardianId);

    }

    public Student getStudentId() {
        return studentId.get();
    }

    public void setStudentId(Student studentId) {
        this.studentId.set(studentId);
    }

    public Guardian getGuardianId() {
        return guardianId.get();
    }

    public void setGuardianId(Guardian guardianId) {
        this.guardianId.set(guardianId);
    }

    public FXObjectProperty<Student> studentIdProperty() {
        return studentId;
    }

    public FXObjectProperty<Guardian> guardianIdProperty() {
        return guardianId;
    }

    @Override
    public FXModel clone() {
        StudentGuardian studentGuardian = new StudentGuardian(this.getStudentId(), this.getGuardianId());
        return studentGuardian;

    }

    @Override
    public void copy(FXModel arg0) {
        StudentGuardian studentGuardian = (StudentGuardian) arg0;
        this.setStudentId(studentGuardian.getStudentId());
        this.setGuardianId(studentGuardian.getGuardianId());
    }

}
