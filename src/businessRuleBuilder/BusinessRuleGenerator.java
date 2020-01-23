package businessRuleBuilder;

public interface BusinessRuleGenerator {
    public boolean execute(int businessRuleId);
    public String example(int businessRuleId);
}
