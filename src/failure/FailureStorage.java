package failure;

public interface FailureStorage {
    public Failure getByBusinessRule(int businessRuleId);
}
