package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Guardian extends FXModel {

    private FXIntegerProperty gurdianID;
    private FXStringProperty firstName;
    private FXStringProperty middleName;
    private FXStringProperty lastName;
    private FXStringProperty relationship;
    private FXIntegerProperty contact;

    public Guardian(int gurdianID,
            String firstName,
            String middleName,
            String lastName,
            String relationship,
            int contact) {
        this.gurdianID = new FXIntegerProperty(gurdianID);
        this.firstName = new FXStringProperty(firstName);
        this.middleName = new FXStringProperty(middleName);
        this.lastName = new FXStringProperty(lastName);
        this.relationship = new FXStringProperty(relationship);
        this.contact = new FXIntegerProperty(contact);

    }

    public FXIntegerProperty gurdianIDProperty() {
        return this.gurdianID;
    }

    public int getGuardianID() {
        return this.gurdianIDProperty().get();
    }

    public void setGuardianID(int gurdianID) {
        gurdianIDProperty().set(gurdianID);
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

    public FXStringProperty relationshipProperty() {
        return this.relationship;
    }

    public String getRelationship() {
        return this.relationshipProperty().get();
    }

    public void setRelationship(String relationship) {
        relationshipProperty().set(relationship);
    }

    public FXIntegerProperty contactProperty() {
        return this.contact;
    }

    public int getContact() {
        return this.contactProperty().get();
    }

    public void setContact(int contact) {
        contactProperty().set(contact);
    }

    @Override
    public FXModel clone() {
        Guardian guardian = new Guardian(getGuardianID(), getFirstName(), getMiddleName(), getLastName(),
                getRelationship(), getGuardianID());
        return guardian;
    }

    @Override

    public void copy(FXModel arg0) {
        Guardian c = (Guardian) arg0;
        setGuardianID(c.getGuardianID());
        setFirstName(c.getFirstName());
        setMiddleName(c.getMiddleName());
        setLastName(c.getLastName());
        setRelationship(c.getRelationship());
        setContact(c.getContact());

    }

}
