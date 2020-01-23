package execute;

import connections.OracleTargetDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteService {
    public static boolean execute(int businessRuleId, String code) {
        try (Connection con = OracleTargetDbConnection.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            stmt.executeQuery(code);

            String query = "UPDATE BUSINESS_RULES SET IS_EXECUTED = 1 WHERE ID = "+businessRuleId;
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }
}
