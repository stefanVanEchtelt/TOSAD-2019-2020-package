package businessRuleBuilder;

public interface BusinessRuleGenerator {
    public boolean execute(int businessRuleId);
    public boolean delete(int businessRuleId);
    public String example(int businessRuleId);
}
