package failure;

public class FailureService {
    public Failure getByBusinessRule(int businessRuleId) {
        return Failure.getByBusinessRule(businessRuleId);
    }
}
