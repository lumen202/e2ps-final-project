package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;

public class AttendanceLog extends FXModel {

    private FXIntegerProperty log_id;
    private FXIntegerProperty month;
    private FXIntegerProperty day;
    private FXIntegerProperty year;

    public AttendanceLog (Integer log_id,
                          Integer month,
                          Integer day,
                          Integer year){

                            this.log_id = new FXIntegerProperty(log_id);
                            this.month = new FXIntegerProperty(month);
                            this.day = new FXIntegerProperty(day);
                            this.year = new FXIntegerProperty(year);

                            track_properties(this.log_id,
                                             this.month,
                                             this.day, 
                                             this.year);
    }
     // Log_id
     public FXIntegerProperty log_idProperty() {
         return log_id;
     }

     public Integer getLogId() {
         return log_idProperty().get();
     }

     public void setLogId(Integer log_ID) {
         log_idProperty().set(log_ID);

     }
     // Month
     public FXIntegerProperty monthProperty() {
         return month;
     }

     public Integer getMonth() {
         return monthProperty().get();
     }

     public void setMonth(Integer month) {
         monthProperty().set(month);

     }
     //Day
     public FXIntegerProperty daProperty() {
         return day;
     }

     public Integer getDay() {
         return daProperty().get();
     }

     public void setDay(Integer day) {
         daProperty().set(day);
     }
     //year
     public FXIntegerProperty yeaProperty() {
         return year;
     }

     public Integer getYear() {
         return yeaProperty().get();
     }

     public void setYear(Integer year) {
         yeaProperty().set(year);
     }

    @Override
    public FXModel clone() {
       AttendanceLog attendanceLog = new AttendanceLog(getLogId(),
                                                       getMonth(),
                                                       getDay(),
                                                       getYear());
         return attendanceLog;
    }

    @Override
    public void copy(FXModel arg0) {
       AttendanceLog c = (AttendanceLog) arg0;
       
       setLogId(c.getDay());
       setMonth(c.getMonth());
       setDay(c.getDay());
       setYear(c.getYear());
    }
    
}
