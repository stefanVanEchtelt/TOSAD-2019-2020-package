package failure;

import connections.OracleToolDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleFailureStorage implements FailureStorage {
    public Failure getByBusinessRule(int businessRuleId) {
        Failure failure = null;

        // get failure by businessRuleId
        try (Connection con = OracleToolDbConnection.getInstance().getConnection()) {
            String query = "select * from FAILURES where busiNESS_RULES_ID = " + businessRuleId;
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet dbResultSet = pstmt.executeQuery();

            while (dbResultSet.next()) {
                failure = new Failure(
                    dbResultSet.getInt("id"),
                    dbResultSet.getString("name"),
                    dbResultSet.getInt("code"),
                    dbResultSet.getString("message")
                );
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return failure;
    }
}
