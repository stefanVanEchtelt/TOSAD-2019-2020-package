package value;

public interface Value {
    public String getUsableValue(String onTableName);
    public String getOfficialValue();
    public boolean isColumn();
}
