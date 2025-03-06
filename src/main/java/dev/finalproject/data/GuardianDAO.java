package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.models.Guardian;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class GuardianDAO {

    private static final String GUARDIAN_TABLE = "guardian";
    private static final DBService DB = App.DB_SMS;

    public static Guardian data(CachedRowSet crs) {
        try {
            int guardianID = crs.getInt("guardianID");
            String firstName = crs.getString("firstName");
            String lastName = crs.getString("lastName");
            String middleName = crs.getString("middleName");
            String contactNumber = crs.getString("contactInfo");
            String relationship = crs.getString("relationship");
            return new Guardian(guardianID,
                    firstName,
                    lastName,
                    middleName,
                    relationship,
                    contactNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DBParam[] paramList(Guardian guardian) {
        List<DBParam> paramList = new LinkedList<>();

        paramList.add(new DBParam(DBType.NUMERIC, "guardianID", guardian.getGuardianID()));
        paramList.add(new DBParam(DBType.TEXT, "firstName", guardian.getFirstName()));
        paramList.add(new DBParam(DBType.TEXT, "lastName", guardian.getLastName()));
        paramList.add(new DBParam(DBType.TEXT, "middleName", guardian.getMiddleName()));
        paramList.add(new DBParam(DBType.TEXT, "contactInfo", guardian.getContact())); // Changed from contactNumber
        paramList.add(new DBParam(DBType.TEXT, "relationship", guardian.getRelationship()));

        return paramList.toArray(new DBParam[0]);
    }

    public static List<Guardian> getGuardianList() {
        CachedRowSet crs = DB.select(GUARDIAN_TABLE);
        List<Guardian> list = new LinkedList<>();
        try {
            while (crs.next()) {
                Guardian guardian = data(crs);
                if (guardian != null) {
                    list.add(guardian);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(Guardian guardian) {
        DB.insert(GUARDIAN_TABLE, paramList(guardian));
    }

    public static void delete(Guardian guardian) {
        DB.delete(GUARDIAN_TABLE, new DBParam(DBType.NUMERIC, "guardianID", guardian.getGuardianID()));
    }

    public static void update(Guardian guardian) {
        DB.update(GUARDIAN_TABLE, new DBParam(DBType.NUMERIC, "guardianID", guardian.getGuardianID()),
                paramList(guardian));
    }
}
