package businessRule;

public class BusinessRuleService {
    public BusinessRule getBusinessRule(int businessRuleId) {
        return BusinessRule.getById(businessRuleId);
    }
}
