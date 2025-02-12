package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Address extends FXModel {

    private FXObjectProperty<Student> student_ID;
    private FXStringProperty city;
    private FXStringProperty municipality;
    private FXStringProperty street;
    private FXStringProperty barangay;
    private FXIntegerProperty ZIP_code;

    public Address(Student student_ID, String city, String municipality, String street, String barangay, int ZIP_code) {
        this.student_ID = new FXObjectProperty<Student>(student_ID);
        this.city = new FXStringProperty(city);
        this.municipality = new FXStringProperty(municipality);
        this.street = new FXStringProperty(street);
        this.barangay = new FXStringProperty(barangay);
        this.ZIP_code = new FXIntegerProperty(ZIP_code);
    }

    // Property
    public FXObjectProperty<Student> studentIDProperty() {
        return this.student_ID;
    }

    public FXStringProperty cityProperty() {
        return this.city;
    }

    public FXStringProperty municipalityProperty() {
        return this.municipality;
    }

    public FXStringProperty streetProperty() {
        return this.street;
    }

    public FXStringProperty barangayProperty() {
        return this.barangay;
    }

    public FXIntegerProperty ZIP_codeProperty() {
        return this.ZIP_code;
    }

    // Gatters and Setters
    public int getStudent_ID() {
        return this.studentIDProperty().get().getStudentID();
    }

    public void setStudent_ID(int student_ID) {
        studentIDProperty().get().setStudentID(student_ID);
    }

    public String getCity() {
        return this.cityProperty().get();
    }

    public void setCity(String city) {
        cityProperty().set(city);
    }

    public String getMunicipality() {
        return this.municipalityProperty().get();
    }

    public void setMunipality(String municipality) {
        municipalityProperty().set(municipality);
    }

    public String getStreet() {
        return this.streetProperty().get();
    }

    public void setStreet(String street) {
        streetProperty().set(street);
    }

    public String getBarangay() {
        return this.barangayProperty().get();
    }

    public void setBarangay(String barangay) {
        barangayProperty().set(barangay);
    }

    public int getZIP_Code() {
        return this.ZIP_codeProperty().get();
    }

    public void setZIP_Code(int ZIP_code) {
        ZIP_codeProperty().set(ZIP_code);
    }

    @Override
    public FXModel clone() {
        Address address = new Address(this.student_ID.get(), this.cityProperty().get(),
                this.municipalityProperty().get(),
                this.streetProperty().get(), this.barangayProperty().get(), this.ZIP_codeProperty().get());
        return address;
    }

    @Override
    public void copy(FXModel arg0) {
        Address c = (Address) arg0;
        setStudent_ID(c.getStudent_ID());
        setCity(c.getCity());
        setMunipality(c.getMunicipality());
        setStreet(c.getStreet());
        setBarangay(c.getBarangay());
        setZIP_Code(c.getZIP_Code());
    }

}