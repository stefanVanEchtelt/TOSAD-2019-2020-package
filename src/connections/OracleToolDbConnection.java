package connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleToolDbConnection {
    private static OracleToolDbConnection instance;

    public static OracleToolDbConnection getInstance() {
        if (OracleToolDbConnection.instance == null) {
            OracleToolDbConnection.instance = new OracleToolDbConnection();
        }
        return OracleToolDbConnection.instance;
    }

    public Connection getConnection() {
        String url = "jdbc:oracle:thin:@//ondora04.hu.nl:8521/educ27";
        String username = "TOSAD_TOOL_DB";
        String password = "tosadtooldb";

        Connection result = null;
        try {
            result = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }
}