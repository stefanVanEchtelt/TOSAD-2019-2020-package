package value;

public class ValueFactory implements ValueFactoryInterface {
    private boolean isColumn;
    private String value;

    ValueFactory(boolean isColumn, String value) {
        this.isColumn = isColumn;
        this.value = value;
    }

    public Value create()
    {
        if (this.isColumn) {
            String[] splitValue = this.value.split("\\.", this.value.length());
            return new Column(splitValue[splitValue.length - 1]);
        } else {
            return new Literal(this.value);
        }
    }
}
