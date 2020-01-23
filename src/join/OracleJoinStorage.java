package join;

import connections.OracleTargetDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleJoinStorage implements JoinStorage {
    public Join getRelationData(Join join) {
        try (Connection con = OracleTargetDbConnection.getInstance().getConnection()) {

            String query = "SELECT a.constraint_name, a.table_name, a.column_name,  c.owner, c_pk.table_name r_table_name,  b.column_name r_column_name FROM user_cons_columns a " +
                    "JOIN user_constraints c ON a.owner = c.owner AND a.constraint_name = c.constraint_name " +
                    "JOIN user_constraints c_pk ON c.r_owner = c_pk.owner AND c.r_constraint_name = c_pk.constraint_name " +
                    "JOIN user_cons_columns b ON C_PK.owner = b.owner AND  C_PK.CONSTRAINT_NAME = b.constraint_name AND b.POSITION = a.POSITION " +
                    "WHERE c.constraint_type = 'R' AND c_pk.table_name = '" + join.getToTable() + "' AND a.table_name = '" + join.getFromTable() + "'";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet dbResultSet = pstmt.executeQuery();

            while (dbResultSet.next()) {
                join.setFromColumn(dbResultSet.getString("column_name"));
                join.setToColumn(dbResultSet.getString("r_column_name"));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return join;
    }
}
