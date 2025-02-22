package triggerType;

import java.util.List;

public class TriggerType {
    private int id;
    private String name;

    public TriggerType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TriggerType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    static List<TriggerType> getByBusinessRule(int businessRuleId) {
        TriggerTypeStorage triggerTypeStorage = new OracleTriggerTypeStorage();
        return triggerTypeStorage.getByBusinessRule(businessRuleId);
    }
}
