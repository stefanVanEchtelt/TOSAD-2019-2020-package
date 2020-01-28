package connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleTargetDbConnection {
    private static OracleTargetDbConnection instance;

    public static OracleTargetDbConnection getInstance() {
        if (OracleTargetDbConnection.instance == null) {
            OracleTargetDbConnection.instance = new OracleTargetDbConnection();
        }
        return OracleTargetDbConnection.instance;
    }

    public Connection getConnection() {
        // get oracle connection
        String url = "jdbc:oracle:thin:@//ondora04.hu.nl:8521/educ27";
        String username = "TOSAD_TARGET_DB";
        String password = "tosadtargetdb";

        Connection result = null;
        try {
            result = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}
