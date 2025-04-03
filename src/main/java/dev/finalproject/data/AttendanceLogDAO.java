package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.database.DataManager;
import dev.finalproject.models.AttendanceLog;
import dev.finalproject.models.AttendanceRecord;
import dev.finalproject.models.Student;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class AttendanceLogDAO {

    private static final String TABLE = "attendance_log";
    public static final DBService DB = App.DB_SMS;

    
    public static AttendanceLog data(CachedRowSet crs) {
        try {
            int logID = crs.getInt("logID");
            int recordID = crs.getInt("recordID");
            int studentID = crs.getInt("student_id");

            // Retrieve attendance records from the shared DataManager
            List<AttendanceRecord> recordList = DataManager.getInstance()
                    .getCollectionsRegistry().getList("ATTENDANCE_RECORD");
            AttendanceRecord record = recordList.stream()
                    .filter(r -> r.getRecordID() == recordID)
                    .findFirst().orElse(null);
            if (record == null) {
                return null;
            }

            // Retrieve students from the shared DataManager
            List<Student> studentList = DataManager.getInstance()
                    .getCollectionsRegistry().getList("STUDENT");
            Student student = studentList.stream()
                    .filter(s -> s.getStudentID() == studentID)
                    .findFirst().orElse(null);
            if (student == null) {
                return null;
            }

            // Map the time values correctly:
            // time_in_am -> timeInAM, time_in_pm -> timeInPM,
            // time_out_am -> timeOutAM, time_out_pm -> timeOutPM
            int timeInAM = crs.getInt("time_in_am");
            int timeOutAM = crs.getInt("time_out_am");
            int timeInPM = crs.getInt("time_in_pm");
            int timeOutPM = crs.getInt("time_out_pm");

            System.out.println("AttendanceLogDAO.data() - logID: " + logID
                    + ", recordID: " + recordID
                    + ", student: " + student.getStudentID()
                    + ", timeInAM: " + timeInAM
                    + ", timeOutAM: " + timeOutAM
                    + ", timeInPM: " + timeInPM
                    + ", timeOutPM: " + timeOutPM);

            // Note: The constructor now receives timeInAM, timeInPM, timeOutAM, timeOutPM in that order.
            return new AttendanceLog(logID, record, student, timeInAM, timeInPM, timeOutAM, timeOutPM);

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
        paramList.add(new DBParam(DBType.NUMERIC, "time_in_am", record.getTimeInAM()));
        paramList.add(new DBParam(DBType.NUMERIC, "time_out_am", record.getTimeOutAM()));
        paramList.add(new DBParam(DBType.NUMERIC, "time_in_pm", record.getTimeInPM()));
        paramList.add(new DBParam(DBType.NUMERIC, "time_out_pm", record.getTimeOutPM()));
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
        DB.delete(TABLE, new DBParam(DBType.NUMERIC, "logID", record.getLogID()));
    }

    public static void update(AttendanceLog record) {
        DB.update(TABLE, new DBParam(DBType.NUMERIC, "logID", record.getLogID()), paramList(record));
    }

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
