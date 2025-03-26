package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.models.AttendanceLog;
import dev.finalproject.models.AttendanceRecord;
import dev.finalproject.models.Student;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class AttendanceLogDAO {
    private static final String TABLE = "attendance_log";
    public static final DBService DB = App.DB_SMS;

    private static List<Student> STUDENT_LIST;
    private static List<AttendanceRecord> RECORD_LIST; // Renamed from LOG_LIST

    public static void initialize(List<Student> studentList, List<AttendanceRecord> recordList) {
        STUDENT_LIST = studentList;
        RECORD_LIST = recordList; // Store attendance records
    }

    public static AttendanceLog data(CachedRowSet crs) {
        try {
            int logID = crs.getInt("logID");
            int recordID = crs.getInt("recordID");

            AttendanceRecord record = RECORD_LIST.stream()
                    .filter(r -> {
                        try {
                            return r.getRecordID() == recordID;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }).findFirst().orElse(null);

            if (record == null)
                return null;

            Student student = STUDENT_LIST.stream()
                    .filter(s -> {
                        try {
                            return s.getStudentID() == crs.getInt("student_id");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }).findFirst().orElse(null);

            if (student == null)
                return null;

            // Map the time values correctly:
            // DB -> Model mapping:
            // time_in_am -> timeInAM (Morning time in)
            // time_out_am -> timeOutAM (Morning time out)
            // time_in_pm -> timeInPM (Afternoon time in)
            // time_out_pm -> timeOutPM (Afternoon time out)
            int timeInAM = crs.getInt("time_in_am");
            int timeOutAM = crs.getInt("time_out_am");
             int timeInPM = crs.getInt("time_in_pm");
            int timeOutPM = crs.getInt("time_out_pm");

            System.out.println("AttendanceLogDAO.data() - logID: " + logID + ", recordID: " + recordID + ", student: "
                    + student.getStudentID() + ", timeInAM: " + timeInAM + ", timeOutAM: " + timeOutAM + ", timeInPM: "
                    + timeInPM + ", timeOutPM: " + timeOutPM);

            return new AttendanceLog(logID, record, student, timeInAM, timeOutAM, timeInPM, timeOutPM);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DBParam[] paramList(AttendanceLog record) {
        List<DBParam> paramList = new LinkedList<>();

        paramList.add(new DBParam(DBType.NUMERIC, "logID", record.getLogID()));
        // Use the record's unique identifier from the associated AttendanceRecord
        paramList.add(new DBParam(DBType.NUMERIC, "recordID", record.getRecordID().getRecordID()));
        paramList.add(new DBParam(DBType.NUMERIC, "student_id", record.getStudentID().getStudentID()));
        // Ensure time values are mapped correctly to DB columns
        paramList.add(new DBParam(DBType.NUMERIC, "time_in_am", record.getTimeInAM())); // Morning in
        paramList.add(new DBParam(DBType.NUMERIC, "time_out_am", record.getTimeOutAM())); // Morning out
        paramList.add(new DBParam(DBType.NUMERIC, "time_in_pm", record.getTimeInPM())); // Afternoon in
        paramList.add(new DBParam(DBType.NUMERIC, "time_out_pm", record.getTimeOutPM())); // Afternoon out

        return paramList.toArray(new DBParam[0]);
    }

    public static List<AttendanceLog> getAttendanceLogList() {
        CachedRowSet crs = DB.select(TABLE);
        List<AttendanceLog> list = new LinkedList<>();
        try {
            while (crs.next()) {
                AttendanceLog record = data(crs);
                if (record != null) {
                    list.add(record);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(AttendanceLog record) {
        DB.insert(TABLE, paramList(record));
    }

    public static void delete(AttendanceLog record) {
        // Use the unique logID as the primary key in the WHERE clause.
        DB.delete(TABLE, new DBParam(DBType.NUMERIC, "logID", record.getLogID()));
    }

    public static void update(AttendanceLog record) {
        // Use logID to identify which row to update
        DB.update(TABLE, new DBParam(DBType.NUMERIC, "logID", record.getLogID()), paramList(record));
    }

    // Add this method to AttendanceLogDAO if it doesn't exist
    public static AttendanceLog findOrCreateLog(Student student, AttendanceRecord record) {
        AttendanceLog log = getAttendanceLogList().stream()
                .filter(l -> l.getStudentID().equals(student) && l.getRecordID().equals(record))
                .findFirst()
                .orElse(null);

        if (log == null) {
            log = new AttendanceLog(student, record);
            insert(log);
        }

        return log;
    }
    
}
