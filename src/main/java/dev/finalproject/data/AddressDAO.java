package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.models.Address;
import dev.finalproject.models.Student;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;
import javafx.collections.ObservableList;

public class AddressDAO {
    public static final String TABLE = "address";
    public static final DBService DB = App.DB_SMS;

    private static ObservableList<Student> STUDENT_LIST;

    public static void initialize(ObservableList<Student> studentList) {
        STUDENT_LIST = studentList;
    }

    public static Address data(CachedRowSet crs) {
        try {
            Student studentID = STUDENT_LIST.stream()
                    .filter(student -> {
                        try {
                            return student.getStudentID() == (crs.getInt("studentID"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }).findFirst().get();

            int addressID = crs.getInt("addressID");
            String city = crs.getString("city");
            String municipality = crs.getString("municipality");
            String street = crs.getString("street");
            String barangay = crs.getString("barangay");
            int zipCode = crs.getInt("zipCode");

            return new Address(studentID,
                    addressID,
                    city,
                    municipality,
                    street,
                    barangay,
                    zipCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static DBParam[] paramList(Address address) {
        List<DBParam> paramList = new LinkedList<>();

        paramList.add(new DBParam(DBType.NUMERIC, "studentID", address.getStudentID()));
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
        DB.delete(TABLE, new DBParam(DBType.TEXT, "addressID", address.getAddressID()));
    }

    public static void update(Address address) {

        DBParam[] params = paramList(address);

        for (int i = 0; i <= 6; i++) {
            DB.update(TABLE, new DBParam(DBType.TEXT, "addressID",
                    address.getAddressID()), params[i]);
        }

    }
}
