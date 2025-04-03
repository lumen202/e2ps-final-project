package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.database.DataManager;
import dev.finalproject.models.Address;
import dev.finalproject.models.Student;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;
import javafx.collections.ObservableList;

public class AddressDAO {

    public static final String TABLE = "address";
    public static final DBService DB = App.DB_SMS;

    // Removed the static STUDENT_LIST and initialize() method
    public static Address data(CachedRowSet crs) {
        try {
            int studentIDValue = crs.getInt("studentID");
            // Retrieve the fresh student list from DataManager
            ObservableList<Student> studentList = DataManager.getInstance()
                    .getCollectionsRegistry().getList("STUDENT");
            Student student = studentList.stream()
                    .filter(s -> {
                        try {
                            return s.getStudentID() == studentIDValue;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }).findFirst().orElse(null);
            if (student == null) {
                return null;
            }

            int addressID = crs.getInt("addressID");
            String city = crs.getString("city");
            String municipality = crs.getString("municipality");
            String street = crs.getString("street");
            String barangay = crs.getString("barangay");
            int zipCode = crs.getInt("zipCode");

            return new Address(student, addressID, city, municipality, street, barangay, zipCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DBParam[] paramList(Address address) {
        List<DBParam> paramList = new LinkedList<>();
        int studentID = address.getStudentID().getStudentID();
        paramList.add(new DBParam(DBType.NUMERIC, "studentID", studentID));
        paramList.add(new DBParam(DBType.NUMERIC, "addressID", address.getAddressID()));
        paramList.add(new DBParam(DBType.TEXT, "city", address.getCity()));
        paramList.add(new DBParam(DBType.TEXT, "municipality", address.getMunicipality()));
        paramList.add(new DBParam(DBType.TEXT, "street", address.getStreet()));
        paramList.add(new DBParam(DBType.TEXT, "barangay", address.getBarangay()));
        paramList.add(new DBParam(DBType.NUMERIC, "zipCode", address.getZipCode()));
        return paramList.toArray(new DBParam[0]);
    }

    public static List<Address> getAddressesList() {
        CachedRowSet crs = DB.select(TABLE);
        List<Address> list = new LinkedList<>();
        try {
            while (crs.next()) {
                Address address = data(crs);
                if (address != null) {
                    list.add(address);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(Address address) {
        DB.insert(TABLE, paramList(address));
    }

    public static void delete(Address address) {
        DB.delete(TABLE, new DBParam(DBType.NUMERIC, "addressID", address.getAddressID()));
    }

    public static void update(Address address) {
        DBParam[] params = paramList(address);
        DB.update(TABLE, new DBParam(DBType.NUMERIC, "addressID", address.getAddressID()), params);
    }
}
