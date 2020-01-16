package triggerType;

import connections.OracleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleTriggerTypeStorage implements TriggerTypeStorage {
    public List<TriggerType> getByBusinessRule(int businessRuleId) {
        List<TriggerType> triggerTypes = new ArrayList<TriggerType>();

        try (Connection con = OracleConnection.getInstance().getConnection()) {
            String query = "select * from EVENT_TRIGGER_TYPES " +
                    "join BUISNESS_RULE_TRIGGER_EVENTS on id = EVENT_TRIGGER_TYPE_ID " +
                    "where BUISNESS_RULES_ID = " + businessRuleId;
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet dbResultSet = pstmt.executeQuery();

            while (dbResultSet.next()) {
                TriggerType tt = new TriggerType(
                    dbResultSet.getInt("id"),
                    dbResultSet.getString("name")
                );

                triggerTypes.add(tt);
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return triggerTypes;
    }
}
