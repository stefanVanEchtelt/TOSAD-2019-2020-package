public class OracleBusinessRuleGenerator implements BusinessRuleGenerator {
    private BusinessRuleFacade businessRuleFacade = new OracleRuleFacade();

    public boolean execute(int businessRuleId) {
        String br = businessRuleFacade.getRuleCode(businessRuleId);

        // TODO build execute

        return true;
    }

    public String example(int businessRuleId) {
        return businessRuleFacade.getRuleCode(businessRuleId);
    }
}
