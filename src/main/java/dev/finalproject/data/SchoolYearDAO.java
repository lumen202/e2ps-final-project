package dev.finalproject.data;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.models.SchoolYear;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class SchoolYearDAO {
    public static final String TABLE = "school_year";
    public static final DBService DB = App.DB_SMS;

    public static SchoolYear data(CachedRowSet crs) {
        try {
            int yearID = crs.getInt("yearID");
            int yearStart = crs.getInt("year_start");
            int yearEnd = crs.getInt("year_end");
            String monthStart = crs.getString("month_start");
            String monthEnd = crs.getString("monthEnd"); // Changed to match DB column case
            int dayStart = crs.getInt("day_start");
            int dayEnd = crs.getInt("day_end");

            return new SchoolYear(yearID, 
                    yearStart, 
                    yearEnd, 
                    monthStart, 
                    monthEnd, 
                    dayStart, 
                    dayEnd);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DBParam[] paramList(SchoolYear schoolYear) {
        List<DBParam> paramList = new LinkedList<>();

        paramList.add(new DBParam(DBType.NUMERIC, "year_start", schoolYear.getYearStart()));
        paramList.add(new DBParam(DBType.NUMERIC, "year_end", schoolYear.getYearEnd()));
        paramList.add(new DBParam(DBType.TEXT, "month_start", schoolYear.getMonthStart()));
        paramList.add(new DBParam(DBType.TEXT, "monthEnd", schoolYear.getMonthEnd())); // Changed to match DB column case
        paramList.add(new DBParam(DBType.NUMERIC, "day_start", schoolYear.getDayStart()));
        paramList.add(new DBParam(DBType.NUMERIC, "day_end", schoolYear.getDayEnd()));

        return paramList.toArray(new DBParam[0]);
    }

    public static List<SchoolYear> getSchoolYearList() {
        CachedRowSet crs = DB.select(TABLE);
        List<SchoolYear> list = new LinkedList<>();
        try {
            while (crs.next()) {
                SchoolYear schoolYear = data(crs);
                if (schoolYear != null) {
                    list.add(schoolYear);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(SchoolYear schoolYear) {
        DB.insert(TABLE, paramList(schoolYear));
    }

    public static void delete(SchoolYear schoolYear) {
        DB.delete(TABLE, new DBParam(DBType.NUMERIC, "yearID", schoolYear.getYearID()));  // Changed from year_id
    }

    public static void update(SchoolYear schoolYear) {
        DBParam[] params = paramList(schoolYear);

            DB.update(TABLE, new DBParam(DBType.NUMERIC, "yearID",   // Changed from year_id
                    schoolYear.getYearID()), params);
        
    }
}
