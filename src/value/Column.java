package value;

public class Column implements Value {
    private String name;

    public Column(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.name;
    }

    public String getNameWithTable() {
        return this.name;
    }
}
