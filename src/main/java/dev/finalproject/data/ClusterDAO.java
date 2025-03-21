package dev.finalproject.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.finalproject.App;
import dev.finalproject.models.Cluster;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class ClusterDAO {
    public static final String TABLE = "cluster";
    public static final DBService DB = App.DB_SMS;

    public static Cluster data(CachedRowSet crs) {
        try {
            int id = crs.getInt("clusterID");
            String clusterName = crs.getString("clusterName");
            
            return new Cluster(id, clusterName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static DBParam[] paramList(Cluster cluster) {
        List<DBParam> paramList = new LinkedList<>();

        paramList.add(new DBParam(DBType.NUMERIC, "clusterID", cluster.getClusterID()));
        paramList.add(new DBParam(DBType.TEXT, "clusterName", cluster.getClusterName()));

        return paramList.toArray(new DBParam[0]);
    }

    public static List<Cluster> getClusterList() {
        CachedRowSet crs = DB.select(TABLE);
        List<Cluster> list = new LinkedList<>();
        try {
            while (crs.next()) {
                Cluster cluster = data(crs);
                if (cluster != null) {
                    list.add(cluster);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insert(Cluster cluster) {
        DB.insert(TABLE, paramList(cluster));
    }

    public static void delete(Cluster cluster) {
        DB.delete(TABLE, new DBParam(DBType.NUMERIC, "clusterID", cluster.getClusterID()));
    }

    public static void update(Cluster cluster) {

        DB.update(TABLE, new DBParam(DBType.NUMERIC, "clusterID",
                cluster.getClusterID()), paramList(cluster));

    }

}
