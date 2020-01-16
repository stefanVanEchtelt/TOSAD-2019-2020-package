package value;

public class Literal implements Value {
    private String value;

    public Literal(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
