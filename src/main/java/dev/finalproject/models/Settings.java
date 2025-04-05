package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Settings extends FXModel {

    private FXStringProperty settingsID;
    private FXIntegerProperty start;
    private FXIntegerProperty end;

    public Settings(String settingsID, int start, int end) {
        this.settingsID = new FXStringProperty(settingsID);
        this.start = new FXIntegerProperty(start);
        this.end = new FXIntegerProperty(end);
    }

    public FXStringProperty settingsIDProperty() {
        return this.settingsID;
    }

    public FXIntegerProperty startProperty() {
        return this.start;
    }

    public FXIntegerProperty endProperty() {
        return this.end;
    }

    public String getSettingsID() {
        return this.settingsIDProperty().get();
    }

    public void setSettingsID(String settingsID) {
        settingsIDProperty().set(settingsID);
    }

    public int getStart() {
        return this.startProperty().get();
    }

    public void setStart(int start) {
        startProperty().set(start);
    }

    public int getEnd() {
        return this.endProperty().get();
    }

    public void setEnd(int end) {
        endProperty().set(end);
    }

    @Override
    public FXModel clone() {
        return new Settings(getSettingsID(), getStart(), getEnd());
    }

    @Override
    public void copy(FXModel model) {
        Settings settings = (Settings) model;
        setSettingsID(settings.getSettingsID());
        setStart(settings.getStart());
        setEnd(settings.getEnd());
    }
}
