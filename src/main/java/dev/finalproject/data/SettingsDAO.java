package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import dev.finalproject.App;
import dev.finalproject.models.Settings;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class SettingsDAO {

    public static final String TABLE = "settings_attendance";
    public static final DBService DB = App.DB_SMS;

    public static Settings data(CachedRowSet crs) {
        try {
            String settingsID = crs.getString("settingsID");
            int start = crs.getInt("start");
            int end = crs.getInt("end");
            return new Settings(settingsID, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DBParam[] paramList(Settings settings) {
        List<DBParam> paramList = new LinkedList<>();
        paramList.add(new DBParam(DBType.TEXT, "settingsID", settings.getSettingsID()));
        paramList.add(new DBParam(DBType.NUMERIC, "start", settings.getStart()));
        paramList.add(new DBParam(DBType.NUMERIC, "end", settings.getEnd()));
        return paramList.toArray(new DBParam[0]);
    }

    public static List<Settings> getSettingsList() {
        CachedRowSet crs = DB.select(TABLE);
        List<Settings> list = new LinkedList<>();
        try {
            while (crs.next()) {
                Settings settings = data(crs);
                if (settings != null) {
                    list.add(settings);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(Settings settings) {
        DB.insert(TABLE, paramList(settings));
    }

    public static void delete(Settings settings) {
        DB.delete(TABLE, new DBParam(DBType.TEXT, "settingsID", settings.getSettingsID()));
    }

    public static void update(Settings settings) {
        DB.update(TABLE, new DBParam(DBType.TEXT, "settingsID", settings.getSettingsID()), paramList(settings));
    }
}
