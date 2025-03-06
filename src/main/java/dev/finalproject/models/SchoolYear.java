package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class SchoolYear extends FXModel {

    private FXIntegerProperty yearID;
    private FXIntegerProperty yearStart;
    private FXIntegerProperty yearEnd;
    private FXStringProperty monthStart;
    private FXStringProperty monthEnd;
    private FXIntegerProperty dayStart;    // Changed from dateStart
    private FXIntegerProperty dayEnd;      // Changed from dateEnd

    public SchoolYear(int yearID, int yearStart, int yearEnd, String monthStart, String monthEnd, int dayStart, int dayEnd) {
        this.yearID = new FXIntegerProperty(yearID);
        this.yearStart = new FXIntegerProperty(yearStart);
        this.yearEnd = new FXIntegerProperty(yearEnd);
        this.monthStart = new FXStringProperty(monthStart);
        this.monthEnd = new FXStringProperty(monthEnd);
        this.dayStart = new FXIntegerProperty(dayStart);     // Changed
        this.dayEnd = new FXIntegerProperty(dayEnd);         // Changed
    }

    public FXIntegerProperty yearIDProperty() {
        return this.yearID;
    }

    public int getYearID() {
        return this.yearIDProperty().get();
    }

    public void setYearID(int yearID) {
        yearIDProperty().set(yearID);
    }

    public FXIntegerProperty yearStartProperty() {
        return this.yearStart;
    }

    public int getYearStart() {
        return this.yearStartProperty().get();
    }

    public void setYearStart(int yearStart) {
        yearStartProperty().set(yearStart);
    }

    public FXIntegerProperty yearEndProperty() {
        return this.yearEnd;
    }

    public int getYearEnd() {
        return this.yearEndProperty().get();
    }

    public void setYearEnd(int yearEnd) {
        yearEndProperty().set(yearEnd);
    }

    public FXStringProperty monthStartProperty() {
        return this.monthStart;
    }

    public String getMonthStart() {
        return this.monthStartProperty().get();
    }

    public void setMonthStart(String monthStart) {
        monthStartProperty().set(monthStart);
    }

    public FXStringProperty monthEndProperty() {
        return this.monthEnd;
    }

    public String getMonthEnd() {
        return this.monthEndProperty().get();
    }

    public void setMonthEnd(String monthEnd) {
        monthEndProperty().set(monthEnd);
    }

    public FXIntegerProperty dayStartProperty() {            // Changed from dateStartProperty
        return this.dayStart;
    }

    public int getDayStart() {                               // Changed from getDateStart
        return this.dayStartProperty().get();
    }

    public void setDayStart(int dayStart) {                  // Changed from setDateStart
        dayStartProperty().set(dayStart);
    }

    public FXIntegerProperty dayEndProperty() {              // Changed from dateEndProperty
        return this.dayEnd;
    }

    public int getDayEnd() {                                 // Changed from getDateEnd
        return this.dayEndProperty().get();
    }

    public void setDayEnd(int dayEnd) {                     // Changed from setDateEnd
        dayEndProperty().set(dayEnd);
    }

    @Override
    public FXModel clone() {
        SchoolYear schoolYear = new SchoolYear(
            getYearID(),
            getYearStart(),
            getYearEnd(),
            getMonthStart(),
            getMonthEnd(),
            getDayStart(),                                   // Changed
            getDayEnd()                                      // Changed
        );
        return schoolYear;
    }

    @Override
    public void copy(FXModel arg0) {
        SchoolYear sy = (SchoolYear) arg0;
        setYearID(sy.getYearID());
        setYearStart(sy.getYearStart());
        setYearEnd(sy.getYearEnd());
        setMonthStart(sy.getMonthStart());
        setMonthEnd(sy.getMonthEnd());
        setDayStart(sy.getDayStart());                      // Changed
        setDayEnd(sy.getDayEnd());                          // Changed
    }

}
