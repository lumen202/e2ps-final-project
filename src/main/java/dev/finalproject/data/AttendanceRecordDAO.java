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
import javafx.collections.ObservableList;

public class AttendanceRecordDAO {
    public static final String TABLE = "attendance_record";
    public static final DBService DB = App.DB_SMS;

    private static ObservableList<Student> STUDENT_LIST;
    private static ObservableList<AttendanceLog> LOG_LIST;

    public static void initialize(ObservableList<Student> studentList, ObservableList<AttendanceLog> logList) {
        STUDENT_LIST = studentList;
        LOG_LIST = logList;
    }

    public static AttendanceRecord data(CachedRowSet crs) {
        try {
            int recordID = crs.getInt("record_id");
            AttendanceLog logID = LOG_LIST.stream()
                    .filter(log -> {
                        try {
                            return log.getLogID() == (crs.getInt("log_id"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }).findFirst().get();
            Student studentID = STUDENT_LIST.stream()
                    .filter(student -> {
                        try {
                            return student.getStudentID() == (crs.getInt("student_id"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }).findFirst().get();

            int timeInAM = crs.getInt("time_in_am");
            int timeOutAM = crs.getInt("time_out_am");
            int timeInPM = crs.getInt("time_in_pm");
            int timeOutPM = crs.getInt("time_out_pm");

            return new AttendanceRecord(recordID,
                    logID,
                    studentID,
                    timeInAM,
                    timeInPM,
                    timeOutAM,
                    timeOutPM);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static DBParam[] paramList(AttendanceRecord record) {
        List<DBParam> paramList = new LinkedList<>();

        paramList.add(new DBParam(DBType.NUMERIC, "log_id", record.getLogID().getLogID()));
        paramList.add(new DBParam(DBType.NUMERIC, "student_id", record.getStudentID().getStudentID()));
        paramList.add(new DBParam(DBType.NUMERIC, "time_in_am", record.getTimeInAM()));
        paramList.add(new DBParam(DBType.NUMERIC, "time_out_am", record.getTimeOutAM()));
        paramList.add(new DBParam(DBType.NUMERIC, "time_in_pm", record.getTimeInPM()));
        paramList.add(new DBParam(DBType.NUMERIC, "time_out_pm", record.getTimeOutPM()));

        return paramList.toArray(new DBParam[0]);
    }

    public static List<AttendanceRecord> getAttendanceRecordList() {
        CachedRowSet crs = DB.select(TABLE);
        List<AttendanceRecord> list = new LinkedList<>();
        try {
            while (crs.next()) {
                AttendanceRecord record = data(crs);
                if (record != null) {
                    list.add(record);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(AttendanceRecord record) {
        DB.insert(TABLE, paramList(record));
    }

    public static void delete(AttendanceRecord record) {
        DB.delete(TABLE, new DBParam(DBType.NUMERIC, "record_id", record.getRecordID()));
    }

    public static void update(AttendanceRecord record) {
        DB.update(TABLE, new DBParam(DBType.NUMERIC, "record_id", record.getRecordID()), paramList(record));
    }
}
