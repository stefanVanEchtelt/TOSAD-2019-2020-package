package failure;

import connections.OracleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleFailureStorage implements FailureStorage {
    public Failure getByBusinessRule(int businessRuleId) {
        Failure failure = null;

        try (Connection con = OracleConnection.getInstance().getConnection()) {
            String query = "select * from FAILURES where BUISNESS_RULES_ID = " + businessRuleId;
            System.out.println(query);
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
