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
        String url = "jdbc:oracle:thin:@localhost:49161:xe";
        String username = "STEFAN";
        String password = "hallo123";

        Connection result = null;
        try {
            result = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }
}