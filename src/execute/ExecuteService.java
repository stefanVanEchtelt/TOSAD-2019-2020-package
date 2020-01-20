package execute;

import connections.OracleTargetDbConnection;

import java.sql.*;

public class ExecuteService {
    public static boolean execute(int businessRuleId, String code) {
        try (Connection con = OracleTargetDbConnection.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            stmt.executeQuery(code);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }
}
