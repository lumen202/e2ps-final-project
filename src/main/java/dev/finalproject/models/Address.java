package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Address extends FXModel{

    private FXObjectProperty<Student> student_id;
    private FXStringProperty city;
    private FXStringProperty municipality;
    private FXStringProperty street;
    private FXStringProperty barangay;
    private FXIntegerProperty ZIPcode;

    public Address(Student student_id, String city, String municipality, String street, String barangay, Integer ZIPcode){
        this.student_id = new FXObjectProperty<>(student_id);
        this.city = new FXStringProperty(city);
        this.municipality = new FXStringProperty(municipality);
        this.street = new FXStringProperty(street);
        this.barangay = new FXStringProperty(barangay);
        this.ZIPcode = new FXIntegerProperty(ZIPcode);

        track_properties(this.student_id, this.city, this.municipality, this.street, this.barangay, this.ZIPcode);
    }

    // student_id
    public FXObjectProperty<Student> student_idProperty(){
        return student_id;
    }
    public Student getStudentId(){
        return student_idProperty().get();
    }
    public void setStudentId(Student student_id){
        student_idProperty().set(student_id);
    }

    //city
    public FXStringProperty cityProperty() {
        return city;
    }

    public String getCity() {
        return cityProperty().get();
    }

    public void setCity(String city) {
        cityProperty().set(city);
    }

    // municipality
    public FXStringProperty municipalityProperty() {
        return municipality;
    }

    public String getMunicipality() {
        return municipalityProperty().get();
    }

    public void setMunicipality(String municipality) {
        municipalityProperty().set(municipality);
    }

    // Street
    public FXStringProperty streetProperty() {
        return street;
    }

    public String getStreet() {
        return streetProperty().get();
    }

    public void setStreet(String street) {
        streetProperty().set(street);
    }
    
    // barangay
    public FXStringProperty barangayProperty() {
        return barangay;
    }

    public String getBarangay() {
        return barangayProperty().get();
    }

    public void setBarangay(String barangay) {
        barangayProperty().set(barangay);
    }

    // ZIPcode
    public FXIntegerProperty zipcodeProperty() {
        return ZIPcode;
    }

    public Integer getZIPcode() {
        return zipcodeProperty().get();
    }

    public void setZIPcode(Integer ZIPcode) {
        zipcodeProperty().set(ZIPcode);
    }

    @Override
    public FXModel clone() {
        Address address = new Address(getStudentId(), getCity(), getMunicipality(), getStreet(), getBarangay(), getZIPcode());

        return address;
    }

    @Override
    public void copy(FXModel arg0) {
       Address c = (Address) arg0;

       setStudentId(c.getStudentId());
       setCity(c.getCity());
       setMunicipality(c.getMunicipality());
       setStreet(c.getStreet());
       setBarangay(c.getBarangay());
       setZIPcode(c.getZIPcode());
    }
    
}
