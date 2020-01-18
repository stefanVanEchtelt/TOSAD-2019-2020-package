package value;

import java.util.List;

public class ValueService {
    private ValueStorage valueStorage = new OracleValueStorage();

    public List<Value> getValuesByRule(int ruleId) {
        return valueStorage.getValuesByRule(ruleId);
    }
}
