package dev.finalproject.models;

import java.util.Date;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXBooleanProperty;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Student extends FXModel {
    private FXIntegerProperty studentID;
    private FXStringProperty firstName;
    private FXStringProperty middleName;
    private FXStringProperty lastName;
    private FXStringProperty nameExtension;
    private FXStringProperty email;
    private FXStringProperty status;
    private FXStringProperty contact;
    private FXObjectProperty<Date> dateOfBirth;
    private FXDoubleProperty fare;
    private FXObjectProperty<Cluster> clusterID;
    private FXObjectProperty<SchoolYear> yearID;
    private FXIntegerProperty archieved;

    public Student(int studentID,
            String firstName,
            String middleName,
            String lastName,
            String nameExtension,
            String email,
            String status,
            String contact,
            Date dateOfBirth,
            double fare,
            Cluster clusterID,
            SchoolYear yearID,
            int archieved) {
        this.studentID = new FXIntegerProperty(studentID);
        this.firstName = new FXStringProperty(firstName);
        this.middleName = new FXStringProperty(middleName);
        this.lastName = new FXStringProperty(lastName);
        this.nameExtension = new FXStringProperty(nameExtension);
        this.email = new FXStringProperty(email);
        this.status = new FXStringProperty(status);
        this.contact = new FXStringProperty(contact);
        this.dateOfBirth = new FXObjectProperty<Date>(dateOfBirth);
        this.fare = new FXDoubleProperty(fare);
        this.clusterID = new FXObjectProperty<Cluster>(clusterID);
        this.yearID = new FXObjectProperty<SchoolYear>(yearID);
        this.archieved = new FXIntegerProperty(archieved);

    }

    public FXIntegerProperty studentIDProperty() {
        return this.studentID;
    }

    public int getStudentID() {
        return this.studentIDProperty().get();
    }

    public void setStudentID(int studentID) {
        studentIDProperty().set(studentID);
    }

    public FXStringProperty firstNameProperty() {
        return this.firstName;
    }

    public String getFirstName() {
        return this.firstNameProperty().get();
    }

    public void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }

    public FXStringProperty middleNameProperty() {
        return this.middleName;
    }

    public String getMiddleName() {
        return this.middleNameProperty().get();
    }

    public void setMiddleName(String middleName) {
        middleNameProperty().set(middleName);
    }

    public FXStringProperty lastNameProperty() {
        return this.lastName;
    }

    public String getLastName() {
        return this.lastNameProperty().get();
    }

    public void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }

    public FXStringProperty nameExtensionProperty() {
        return this.nameExtension;
    }

    public String getNameExtension() {
        return this.nameExtensionProperty().get();
    }

    public void setNameExtension(String nameExtension) {
        nameExtensionProperty().set(nameExtension);
    }

    public FXStringProperty emailProperty() {
        return this.email;
    }

    public String getEmail() {
        return this.emailProperty().get();
    }

    public void setEmail(String email) {
        emailProperty().set(email);
    }

    public FXStringProperty statusProperty() {
        return this.status;
    }

    public String getStatus() {
        return this.statusProperty().get();
    }

    public void setStatus(String status) {
        statusProperty().set(status);
    }

    public FXStringProperty contactProperty() {
        return this.contact;
    }

    public String getContact() {
        return this.contactProperty().get();
    }

    public void setContact(String contact) {
        contactProperty().set(contact);
    }

    public FXObjectProperty<Date> dateOfBirthProperty() {
        return this.dateOfBirth;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirthProperty().get();
    }

    public void setDateOfBirth(Date dateOfBirth) {
        dateOfBirthProperty().set(dateOfBirth);
    }

    public FXDoubleProperty fareProperty() {
        return this.fare;
    }

    public double getFare() {
        return this.fareProperty().get();
    }

    public void setFare(double fare) {
        fareProperty().set(fare);
    }

    public FXObjectProperty<Cluster> clusterIDProperty() {
        return this.clusterID;
    }

    public Cluster getClusterID() {
        return this.clusterIDProperty().get();
    }

    public void setClusterID(Cluster clusterID) {
        clusterIDProperty().set(clusterID);
    }

    public FXObjectProperty<SchoolYear> yearIDProperty() {
        return this.yearID;
    }

    public SchoolYear getYearID() {
        return this.yearIDProperty().get();
    }

    public void setYearID(SchoolYear yearID) {
        yearIDProperty().set(yearID);
    }

    public FXIntegerProperty archievedProperty() {
        return this.archieved;
    }

    public Integer getArchieved() {
        return this.archievedProperty().get();
    }

    public void setArchieved(int archieved) {
        archievedProperty().set(archieved);
    }

    public String getFullName() {
        return getFirstName() + " " + getMiddleName() + " " + getLastName() + " " + getNameExtension();
    }

    @Override
    public FXModel clone() {
        Student student = new Student(getStudentID(),
                getFirstName(),
                getMiddleName(),
                getLastName(),
                getNameExtension(),
                getEmail(),
                getStatus(),
                getContact(),
                getDateOfBirth(),
                getFare(),
                getClusterID(),
                getYearID(),
                getArchieved());

        return student;

    }

    @Override
    public void copy(FXModel arg0) {
        Student c = (Student) arg0;
        setStudentID(c.getStudentID());
        setFirstName(c.getFirstName());
        setMiddleName(c.getMiddleName());
        setLastName(c.getLastName());
        setNameExtension(c.getNameExtension());
        setEmail(c.getEmail());
        setStatus(c.getStatus());
        setContact(c.getContact());
        setDateOfBirth(c.getDateOfBirth());
        setFare(c.getFare());
        setClusterID(c.getClusterID());
        setYearID(c.getYearID());
        setArchieved(c.getArchieved());

    }

}
