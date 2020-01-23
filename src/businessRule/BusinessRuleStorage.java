package businessRule;

public interface BusinessRuleStorage {
    public BusinessRule getById(int businessRuleId);
    public boolean deleteFromTargetDb(BusinessRule businessRule);
}
