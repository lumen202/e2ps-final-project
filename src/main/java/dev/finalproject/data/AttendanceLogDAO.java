package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.models.AttendanceLog;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class AttendanceLogDAO {
    private static final String TABLE_NAME = "attendance_log";
    private static final DBService DB = App.DB_SMS;

    public static AttendanceLog data(CachedRowSet crs) {
        try {
            int logID = crs.getInt("logID");
            int month = crs.getInt("month");
            int day = crs.getInt("day");
            int year = crs.getInt("year");

            return new AttendanceLog(logID, month, day, year);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DBParam[] paramList(AttendanceLog log) {
        List<DBParam> paramList = new LinkedList<>();

        paramList.add(new DBParam(DBType.NUMERIC, "month", log.getMonth()));
        paramList.add(new DBParam(DBType.NUMERIC, "day", log.getDay()));
        paramList.add(new DBParam(DBType.NUMERIC, "year", log.getYear()));

        return paramList.toArray(new DBParam[0]);
    }

    public static List<AttendanceLog> getLogList() {
        CachedRowSet crs = DB.select(TABLE_NAME);
        List<AttendanceLog> list = new LinkedList<>();
        try {
            while (crs.next()) {
                AttendanceLog log = data(crs);
                if (log != null) {
                    list.add(log);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(AttendanceLog log) {
        DB.insert(TABLE_NAME, paramList(log));
    }

    public static void delete(AttendanceLog log) {
        DB.delete(TABLE_NAME, new DBParam(DBType.NUMERIC, "studentID", log.getLogID()));
    }

    public static void update(AttendanceLog log) {
        DB.update(TABLE_NAME, new DBParam(DBType.NUMERIC, "studentID", log.getLogID()), paramList(log));
    }

}
