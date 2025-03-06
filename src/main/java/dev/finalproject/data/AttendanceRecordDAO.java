package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.models.AttendanceRecord;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class AttendanceRecordDAO {
    private static final String TABLE_NAME = "attendance_record";
    private static final DBService DB = App.DB_SMS;

    public static AttendanceRecord data(CachedRowSet crs) {
        try {
            int recordID = crs.getInt("recordID"); // Changed from record_id to match DB
            int month = crs.getInt("Month"); // Capital M to match DB
            int day = crs.getInt("Day"); // Capital D to match DB
            int year = crs.getInt("Year"); // Capital Y to match DB

            return new AttendanceRecord(recordID, month, day, year);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DBParam[] paramList(AttendanceRecord log) {
        List<DBParam> paramList = new LinkedList<>();
        paramList.add(new DBParam(DBType.NUMERIC, "recordID", log.getRecordID()));
        paramList.add(new DBParam(DBType.NUMERIC, "Month", log.getMonth())); // Capital M
        paramList.add(new DBParam(DBType.NUMERIC, "Day", log.getDay())); // Capital D
        paramList.add(new DBParam(DBType.NUMERIC, "Year", log.getYear())); // Capital Y

        return paramList.toArray(new DBParam[0]);
    }

    public static List<AttendanceRecord> getRecordList() {
        CachedRowSet crs = DB.select(TABLE_NAME);
        List<AttendanceRecord> list = new LinkedList<>();
        try {
            while (crs.next()) {
                AttendanceRecord log = data(crs);
                if (log != null) {
                    list.add(log);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(AttendanceRecord log) {
        DB.insert(TABLE_NAME, paramList(log));
    }

    public static void delete(AttendanceRecord record) {
        DB.delete(TABLE_NAME, new DBParam(DBType.NUMERIC, "recordID", record.getRecordID())); // Changed to recordID
    }

    public static void update(AttendanceRecord record) {
        DB.update(TABLE_NAME, new DBParam(DBType.NUMERIC, "recordID", record.getRecordID()), paramList(record)); // Changed
                                                                                                                 // to
                                                                                                                 // recordID
    }

}
