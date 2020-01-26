package businessRule;

import connections.OracleTargetDbConnection;
import connections.OracleToolDbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BusinessRuleOracleStorage implements BusinessRuleStorage {
    public BusinessRule getById(int businessRuleId) {
        BusinessRule businessRule = null;
        try (Connection con = OracleToolDbConnection.getInstance().getConnection()) {
            String query = "select * from busiNESS_RULES where id = " + businessRuleId;
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


    public boolean deleteFromTargetDb(BusinessRule businessRule) {
        boolean result = false;

        try (Connection con = OracleTargetDbConnection.getInstance().getConnection()) {
            String query = "DROP TRIGGER " + businessRule.getName();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeQuery();
            result = true;

            try(Connection toolCon = OracleToolDbConnection.getInstance().getConnection()) {
                String query2 = "UPDATE BUSINESS_RULES SET IS_EXECUTED = 0 WHERE ID = "+ businessRule.getId();
                PreparedStatement pstmt2 = toolCon.prepareStatement(query2);
                pstmt2.executeUpdate();
                return true;
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return result;
    }
}
