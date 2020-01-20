package rule;

import businessRule.BusinessRule;
import connections.OracleToolDbConnection;
import value.Column;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleRuleStorage implements RuleStorage {
    public Rule getRuleByBusinessRule(BusinessRule businessRule) {
        Column col = new Column(businessRule.getColumn());
        Rule rule = new BasicRule(col);

        try (Connection con = OracleToolDbConnection.getInstance().getConnection()) {
            String query = "select * from RULES R " +
                    "where R.BUSINESS_RULES_ID = " + businessRule.getId();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet dbResultSet = pstmt.executeQuery();

            while (dbResultSet.next()) {
                int typeEid = dbResultSet.getInt("TYPE_EID");
                int id = dbResultSet.getInt("id");

                RuleFactoryInterface ruleFactory = new RuleFactory(rule, typeEid, id);
                rule = ruleFactory.create();
            }

        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return rule;
    }
}
