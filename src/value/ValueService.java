package value;

public class ValueService {
    private ValueStorage valueStorage = new OracleValueStorage();

    public Value getValuesByRule(int ruleId) {
        return valueStorage.getValuesByRule(ruleId);
    }
}
