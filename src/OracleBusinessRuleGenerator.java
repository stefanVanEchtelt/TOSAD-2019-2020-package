import execute.ExecuteService;

public class OracleBusinessRuleGenerator implements BusinessRuleGenerator {
    private BusinessRuleFacade businessRuleFacade = new OracleRuleFacade();

    public boolean execute(int businessRuleId) {
        String businessRuleCode = businessRuleFacade.getRuleCode(businessRuleId);

        // TODO error handeling

        boolean success = ExecuteService.execute(businessRuleId, businessRuleCode);

        return true;
    }

    public String example(int businessRuleId) {
        return businessRuleFacade.getRuleCode(businessRuleId);
    }
}
