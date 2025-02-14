package dev.finalproject.data;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.models.Cluster;
import dev.finalproject.models.Student;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;
import javafx.collections.ObservableList;

public class StudentDAO {
    public static final String TABLE = "student";
    public static final DBService DB = App.DB_SMS;

    private static ObservableList<Cluster> CLUSTER_LIST;

    public static void initialize(ObservableList<Cluster> clusterList) {
        CLUSTER_LIST = clusterList;
    }

    public static Student data(CachedRowSet crs) {

        try {

            Cluster clusterID = CLUSTER_LIST.stream()
                    .filter(cluster -> {
                        try {
                            return cluster.getClusterID() == (crs.getInt("clusterID"));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }).findFirst().get();

            int id = crs.getInt("StudentID");
            String firstName = crs.getString("FirstName");
            String middleName = crs.getString("MiddleName");
            String lastName = crs.getString("LastName");
            String nameExtension = crs.getString("NameExtension");
            String email = crs.getString("Email");
            String status = crs.getString("Status");
            int contact = crs.getInt("ContactInfo");
            Date dateOfBirth = crs.getDate("DateOfBirth");
            double fare = crs.getDouble("Fare");

            return new Student(id,
                    firstName,
                    middleName,
                    lastName,
                    nameExtension,
                    email,
                    status,
                    contact,
                    dateOfBirth,
                    fare,
                    clusterID);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static DBParam[] paramList(Student student) {
        List<DBParam> paramList = new LinkedList<>();

        paramList.add(new DBParam(DBType.TEXT, "FirstName", student.getFirstName()));
        paramList.add(new DBParam(DBType.TEXT, "MiddleName", student.getMiddleName()));
        paramList.add(new DBParam(DBType.TEXT, "LastName", student.getLastName()));
        paramList.add(new DBParam(DBType.TEXT, "NameExtension", student.getNameExtension()));
        paramList.add(new DBParam(DBType.TEXT, "Email", student.getEmail()));
        paramList.add(new DBParam(DBType.TEXT, "Status", student.getStatus()));
        paramList.add(new DBParam(DBType.NUMERIC, "ContactInfo", student.getContact()));
        paramList.add(new DBParam(DBType.DATE, "DateOfBirth", student.getDateOfBirth()));
        paramList.add(new DBParam(DBType.NUMERIC, "Fare", student.getFare()));
        paramList.add(new DBParam(DBType.NUMERIC, "ClusterID", student.getClusterID()));

        return paramList.toArray(new DBParam[0]);
    }

    public static List<Student> getStudentList() {
        CachedRowSet crs = DB.select(TABLE);
        List<Student> list = new LinkedList<>();
        try {
            while (crs.next()) {
                Student student = data(crs);
                if (student != null) {
                    list.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(Student student) {
        DB.insert(TABLE, paramList(student));
    }

    public static void delete(Student student) {
        DB.delete(TABLE, new DBParam(DBType.NUMERIC, "StudentID", student.getStudentID()));
    }

    public static void update(Student student) {

        DBParam[] params = paramList(student);

        for (int i = 0; i <= 10; i++) {
            DB.update(TABLE, new DBParam(DBType.NUMERIC, "StudentID",
                    student.getStudentID()), params[i]);
        }

    }
}
