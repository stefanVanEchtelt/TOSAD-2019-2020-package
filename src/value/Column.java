package value;

public class Column implements Value {
    private String name;
    private String tableName;

    public Column(String name, String tableName) {
        this.name = name;
        this.tableName = tableName;
    }

    public String getName() {
        return this.name;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getOfficialValue() {
        return this.tableName + "." + this.name;
    }

    public boolean isColumn() {
        return true;
    }

    public String getUsableValue(String onTableName) {
        if (!onTableName.equals(this.tableName)) {
            return this.getOfficialValue().replace(".", "_");
        }
        return ":new." + this.name;
    }

    public String getUsableName() {
        return ":new." + this.name;
    }
}
