package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.models.Guardian;
import dev.finalproject.models.Student;
import dev.finalproject.models.StudentGuardian;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;
import javafx.collections.ObservableList;

public class StudentGuardianDAO {

    public static final String TABLE_NAME = "student_guardian";
    public static final DBService DB = App.DB_SMS;

    public static final ObservableList<Student> STUDENT_LIST = App.COLLECTIONS_REGISTRY.getList("STUDENT");
    public static final ObservableList<Guardian> GUARDIAN_LIST = App.COLLECTIONS_REGISTRY.getList("GUARDIAN");

    public static StudentGuardian data(CachedRowSet crs) {
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

            Guardian guardianID = GUARDIAN_LIST.stream()
                    .filter(guardian -> {
                        try {
                            return guardian.getGuardianID() == (crs.getInt("guardianID"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }).findFirst().get();

            return new StudentGuardian(studentID, guardianID);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static DBParam[] paramList(StudentGuardian studentGuardian) {
        List<DBParam> paramList = new LinkedList<>();

        paramList.add(new DBParam(DBType.NUMERIC, "studentID", studentGuardian.getStudentId().getStudentID()));
        paramList.add(new DBParam(DBType.NUMERIC, "guardianID", studentGuardian.getGuardianId().getGuardianID()));

        return paramList.toArray(new DBParam[0]);
    }

    public static List<StudentGuardian> getStudentGuardianList() {
        CachedRowSet crs = DB.select(TABLE_NAME);
        List<StudentGuardian> list = new LinkedList<>();
        try {
            while (crs.next()) {
                StudentGuardian studentGuardian = data(crs);
                if (studentGuardian != null) {
                    list.add(studentGuardian);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(StudentGuardian studentGuardian) {
        DB.insert(TABLE_NAME, paramList(studentGuardian));
    }

    public static void delete(StudentGuardian studentGuardian) {
        DB.delete(TABLE_NAME, new DBParam(DBType.NUMERIC, "studentID", studentGuardian.getStudentId().getStudentID()));
    }

    public static void update(StudentGuardian studentGuardian) {
        DB.update(TABLE_NAME, new DBParam(DBType.NUMERIC, "studentID", studentGuardian.getStudentId().getStudentID()),
                paramList(studentGuardian));
    }

}
