package rule;

import businessRule.BusinessRule;
import connections.OracleConnection;
import value.Column;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleRuleStorage implements RuleStorage {
    public Rule getRuleByBusinessRule(BusinessRule businessRule) {
        // TODO get BR column ...
        Column col = new Column("leeftijd");

        Rule rule = new BasicRule(col);

        try (Connection con = OracleConnection.getInstance().getConnection()) {
            String query = "select * from RULES R " +
                    "where R.BUISNESS_RULES_ID = " + businessRule.getId();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet dbResultSet = pstmt.executeQuery();

            while (dbResultSet.next()) {
                int typeEid = dbResultSet.getInt("TYPE_EID");

                RuleFactoryInterface ruleFactory = new RuleFactory(rule, typeEid);
                rule = ruleFactory.create();
            }

        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return rule;
    }
}
