package triggerType;

import java.util.List;

public class TriggerTypeService {
    public List<TriggerType> getByBusinessRule(int businessRuleId) {
        return TriggerType.getByBusinessRule(businessRuleId);
    }
}
