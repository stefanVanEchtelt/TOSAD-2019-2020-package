package businessRule;

import connections.OracleConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BusinessRuleOracleStorage implements BusinessRuleStorage {
    public BusinessRule getById(int businessRuleId) {
        BusinessRule businessRule = null;
        try (Connection con = OracleConnection.getInstance().getConnection()) {
            String query = "select * from BUISNESS_RULES where id = " + businessRuleId;
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet dbResultSet = pstmt.executeQuery();

            while (dbResultSet.next()) {
                businessRule = new BusinessRule(
                        dbResultSet.getInt("id"),
                        dbResultSet.getString("name"),
                        dbResultSet.getString("on_table"),
                        dbResultSet.getString("on_column")
                );
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return businessRule;
    }
}
