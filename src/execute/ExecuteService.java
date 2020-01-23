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
            Statement stmt = con.createStatement();
            stmt.executeQuery(code);
            System.out.println("done??");

            try(Connection toolCon = OracleToolDbConnection.getInstance().getConnection()) {
                System.out.println("test");
                String query = "UPDATE BUSINESS_RULES SET IS_EXECUTED = 1 WHERE ID = "+businessRuleId;
                PreparedStatement pstmt = toolCon.prepareStatement(query);
                pstmt.executeUpdate();
                System.out.println("done??xxx");
                return true;
            } catch (SQLException sqle) {
                System.out.println("error with tooldb");
                sqle.printStackTrace();
            }


        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
}
