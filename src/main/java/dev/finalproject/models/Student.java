package dev.finalproject.models;

import java.sql.Date;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Student extends FXModel{

    private FXIntegerProperty student_id;
    private FXStringProperty firstname;
    private FXStringProperty lastname;
    private FXStringProperty middlename;
    private FXStringProperty name_extension;
    private FXStringProperty email;
    private FXStringProperty status;
    private FXIntegerProperty contact_info;
    private FXObjectProperty<Date> dateofbirth;
    private FXDoubleProperty fare;
    private FXIntegerProperty cluster_id;
    
    public Student(Integer student_id, 
                String firstname, 
                String lastname, 
                String middlename,
                String name_extension,
                String email,
                String status,
                Integer contact_info,
                Date dateofbirth,
                Double fare,
                Integer cluster_id){
                    this.student_id  = new FXIntegerProperty(student_id);
                    this.firstname = new FXStringProperty(firstname);
                    this.lastname = new FXStringProperty(lastname);
                    this.middlename = new FXStringProperty(middlename);
                    this.name_extension = new FXStringProperty(name_extension);
                    this.email = new FXStringProperty(email);
                    this.status = new FXStringProperty(status);
                    this.contact_info = new FXIntegerProperty(contact_info);
                    this.dateofbirth = new FXObjectProperty<>(dateofbirth);
                    this.fare = new FXDoubleProperty(fare);
                    this.cluster_id = new FXIntegerProperty(cluster_id);

                    track_properties(this.student_id, 
                                    this.firstname, 
                                    this.lastname, 
                                    this.middlename, 
                                    this.name_extension, 
                                    this.email, 
                                    this.status, 
                                    this.contact_info, 
                                    this.dateofbirth, 
                                    this.fare, 
                                    this.cluster_id);
                }
    
    //Student Id
    public FXIntegerProperty studentIDProperty() {
        return student_id;
    }

    public Integer getStudentID() {
        return studentIDProperty().get();
    }

    public void setStudentID(Integer student_id) {
        studentIDProperty().set(student_id);
    }

    //FirstName
    public FXStringProperty firstnameProperty() {
        return firstname;
    }

    public String getFirstName() {
        return firstnameProperty().get();
    }

    public void setFirstName(String firstname) {
        firstnameProperty().set(firstname);
    }

    //LastName
    public FXStringProperty lastnameProperty() {
        return lastname;
    }

    public String getLastName() {
        return lastnameProperty().get();
    }

    public void setLastName(String lastname) {
        lastnameProperty().set(lastname);
    }

    // Middle Name
    public FXStringProperty middlenameProperty() {
        return middlename;
    }

    public String getMiddleName() {
        return middlenameProperty().get();
    }

    public void setMiddleName(String middlename) {
        middlenameProperty().set(middlename);
    }

    // Name Extension
    public FXStringProperty name_extensionProperty() {
        return name_extension;
    }

    public String getNameExtension() {
        return name_extensionProperty().get();
    }

    public void setNameExtension(String name_extension) {
        name_extensionProperty().set(name_extension);
    }
    
    // Email
    public FXStringProperty emailProperty() {
        return email;
    }

    public String getEmail() {
        return emailProperty().get();
    }

    public void setEmail(String email) {
        emailProperty().set(email);
    }

    // Status
    public FXStringProperty statusProperty() {
        return status;
    }

    public String getStatus() {
        return statusProperty().get();
    }

    public void setStatus(String status) {
        statusProperty().set(status);
    }

    // Contact Info
    public FXIntegerProperty contact_infoProperty() {
        return contact_info;
    }

    public Integer getContactInfo() {
        return contact_infoProperty().get();
    }

    public void setContactInfo(Integer contact_info) {
        contact_infoProperty().set(contact_info);
    }

    // Date of Birth
    public FXObjectProperty<Date> dateofbirthProperty(){
        return dateofbirth;
    }
    public Date getDateOfBirth(){
     return dateofbirthProperty().get();
    }
    public void setDateOfBirth(Date dateofbirth){
        dateofbirthProperty().set(dateofbirth);
    }

    //Fare 
    public FXDoubleProperty fareProperty(){
        return fare;
    }
    public Double getFare(){
        return fareProperty().get();
    }
    public void setFare(Double fare){
        fareProperty().set(fare);
    }

    // cluster Id
    public FXIntegerProperty clusterIdProperty() {
        return cluster_id;
    }

    public Integer getClusterId() {
        return clusterIdProperty().get();
    }

    public void setClusterId(Integer cluster_id) {
        clusterIdProperty().set(cluster_id);
    }



    @Override
    public FXModel clone() {
      Student student = new Student(getStudentID(), 
                                    getFirstName(), 
                                    getLastName(), 
                                    getMiddleName(), 
                                    getNameExtension(), 
                                    getEmail(), 
                                    getStatus(), 
                                    getContactInfo(), 
                                    getDateOfBirth(), 
                                    getFare(), 
                                    getClusterId());
        return student;
    }

    @Override
    public void copy(FXModel arg0) {
        Student c = (Student) arg0;

        setStudentID(c.getStudentID());
        setFirstName(c.getFirstName());
        setLastName(c.getLastName());
        setMiddleName(c.getMiddleName());
        setNameExtension(c.getNameExtension());
        setEmail(c.getEmail());
        setStatus(c.getStatus());
        setContactInfo(c.getClusterId());
        setDateOfBirth(c.getDateOfBirth());
        setFare(c.getFare());
        setClusterId(c.getClusterId());
    }
    
}
