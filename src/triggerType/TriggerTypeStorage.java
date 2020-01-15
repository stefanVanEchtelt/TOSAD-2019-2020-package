package triggerType;

import java.util.List;

public interface TriggerTypeStorage {
    public List<TriggerType> getByBusinessRule(int businessRuleId);
}
