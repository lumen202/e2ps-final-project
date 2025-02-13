package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Address extends FXModel {

    private FXObjectProperty<Student> studentID;
    private FXIntegerProperty addressID;
    private FXStringProperty city;
    private FXStringProperty municipality;
    private FXStringProperty street;
    private FXStringProperty barangay;
    private FXIntegerProperty zipCode;

    public Address(Student studentID,
            int addressID,
            String city,
            String municipality,
            String street,
            String barangay,
            int zipCode) {
        this.studentID = new FXObjectProperty<Student>(studentID);
        this.addressID = new FXIntegerProperty(addressID);
        this.city = new FXStringProperty(city);
        this.municipality = new FXStringProperty(municipality);
        this.street = new FXStringProperty(street);
        this.barangay = new FXStringProperty(barangay);
        this.zipCode = new FXIntegerProperty(zipCode);
    }

    // Property
    public FXObjectProperty<Student> studentIDProperty() {
        return this.studentID;
    }

    public FXIntegerProperty addressIDProperty() {
        return this.addressID;
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

    public FXIntegerProperty ZipCodeProperty() {
        return this.zipCode;
    }

    // Gatters and Setters
    public Student getStudentID() {
        return this.studentIDProperty().get();
    }

    public void setStudentID(Student student_ID) {
        studentIDProperty().set(student_ID);
    }

    public int getAddressID() {
        return this.addressIDProperty().get();
    }

    public void setAddressID(int addressID) {
        addressIDProperty().set(addressID);
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

    public int getZipCode() {
        return this.ZipCodeProperty().get();
    }

    public void setZipCode(int ZIP_code) {
        ZipCodeProperty().set(ZIP_code);
    }

    @Override
    public FXModel clone() {
        Address address = new Address(getStudentID(),
                getAddressID(),
                getCity(),
                getMunicipality(),
                getStreet(),
                getBarangay(),
                getZipCode());
        return address;
    }

    @Override
    public void copy(FXModel arg0) {
        Address c = (Address) arg0;
        setStudentID(c.getStudentID());
        setCity(c.getCity());
        setMunipality(c.getMunicipality());
        setStreet(c.getStreet());
        setBarangay(c.getBarangay());
        setZipCode(c.getZipCode());
    }

}