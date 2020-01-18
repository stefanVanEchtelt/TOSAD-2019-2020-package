package value;

import connections.OracleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleValueStorage implements ValueStorage {
    public List<Value> getValuesByRule(int ruleId) {
        List<Value> values = new ArrayList<Value>();
        try (Connection con = OracleConnection.getInstance().getConnection()) {
            String query = "select * from VAULES where RULE_ID = " + ruleId + " ORDER BY SORT_ORDER";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet dbResultSet = pstmt.executeQuery();

            while (dbResultSet.next()) {
                String v = dbResultSet.getString("value");
                boolean isColumn = dbResultSet.getBoolean("is_column");

                Value value = new ValueFactory(isColumn, v).create();

                values.add(value);
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return values;
    }
}
