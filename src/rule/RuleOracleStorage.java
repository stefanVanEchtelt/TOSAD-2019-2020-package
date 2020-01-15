package rule;

import connections.OracleConnection;
import rule.operators.OperatorFactory;
import values.Column;
import values.Value;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RuleOracleStorage implements RuleStorage {
    public Rule getFullRuleByBusinessRule(int businessRuleId) {
        Column col = new Column("leeftijd");
        Rule rule = new BasicRule(col);

        try (Connection con = OracleConnection.getInstance().getConnection()) {
            String query = "select * from RULES R " +
                    "where R.BUISNESS_RULES_ID = " + businessRuleId;
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet dbResultSet = pstmt.executeQuery();

            while (dbResultSet.next()) {
                int typeEid = dbResultSet.getInt("TYPE_EID");

                // TODO select values!!
                List<Value> values = new ArrayList<Value>();

                rule = new OperatorFactory(typeEid, values, rule).create();
            }

        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return rule;
    }
}
