package value;

public class OracleValueStorage implements ValueStorage {
    public Value getValuesByRule(int ruleId) {
        // TODO get from DB and use factory
        return new Column("xxx");
    }
}
