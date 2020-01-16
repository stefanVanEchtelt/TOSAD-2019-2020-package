package value;

public class ValueFactory implements ValueFactoryInterface {
    ValueFactory() {

    }

    public Value create()
    {
        // TODO fix this
        return new Column("test");
    }
}
