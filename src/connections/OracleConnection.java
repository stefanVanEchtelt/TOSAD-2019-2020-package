package connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnection {
    private static OracleConnection instance;

    public static OracleConnection getInstance() {
        if (OracleConnection.instance == null) {
            OracleConnection.instance = new OracleConnection();
        }
        return OracleConnection.instance;
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