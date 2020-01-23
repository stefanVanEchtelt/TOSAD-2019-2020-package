package join;

public class Join {
    private String fromTable;
    private String toTable;
    private String fromColumn;
    private String toColumn;

    Join (String fromTable, String toTable) {
        this.fromTable = fromTable;
        this.toTable = toTable;
    }

    Join loadFullJoin() {
        JoinStorage joinStorage = new OracleJoinStorage();
        return joinStorage.getRelationData(this);
    }

    public String getFromTable() {
        return this.fromTable;
    }

    public String getToTable() {
        return this.toTable;
    }

    public String getFromColumn() {
        return this.fromColumn;
    }

    public void setFromColumn(String fromColumn) {
        this.fromColumn = fromColumn;
    }

    public String getToColumn() {
        return this.toColumn;
    }

    public void setToColumn(String toColumn) {
        this.toColumn = toColumn;
    }
}
