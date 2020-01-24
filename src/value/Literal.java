package value;

public class Literal implements Value {
    private String value;

    public Literal(String value) {
        this.value = value;
    }

    public boolean isColumn() {
        return false;
    }

    public String getUsableValue(String onTableName) {
        try {
            Integer.parseInt(this.value);
            return this.value;
        } catch(NumberFormatException e) {
            return "'" + this.value + "'";
        }
    }

    public String getOfficialValue() {
        return this.value;
    }
}
