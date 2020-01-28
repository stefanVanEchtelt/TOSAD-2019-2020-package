package execute;

import connections.OracleTargetDbConnection;
import connections.OracleToolDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteService {
    public static boolean execute(int businessRuleId, String code) {
        try (Connection con = OracleTargetDbConnection.getInstance().getConnection()) {
            // add trigger to target DB
            Statement stmt = con.createStatement();
            stmt.executeQuery(code);

            // update BR that is executed
            try(Connection toolCon = OracleToolDbConnection.getInstance().getConnection()) {
                String query = "UPDATE BUSINESS_RULES SET IS_EXECUTED = 1 WHERE ID = "+businessRuleId;
                PreparedStatement pstmt = toolCon.prepareStatement(query);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }


        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
}
