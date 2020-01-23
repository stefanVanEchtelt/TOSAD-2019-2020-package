package businessRuleBuilder;

import execute.ExecuteService;

public class OracleBusinessRuleGenerator implements BusinessRuleGenerator {
    private BusinessRuleFacade businessRuleFacade = new OracleRuleFacade();

    public boolean execute(int businessRuleId) {
        String businessRuleCode = businessRuleFacade.getRuleCode(businessRuleId);

        return ExecuteService.execute(businessRuleId, businessRuleCode);
    }

    public String example(int businessRuleId) {
        return businessRuleFacade.getRuleCode(businessRuleId);
    }
}
