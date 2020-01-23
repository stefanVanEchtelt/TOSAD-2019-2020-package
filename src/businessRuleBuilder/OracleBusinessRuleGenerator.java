package businessRuleBuilder;

import businessRule.BusinessRule;
import businessRule.BusinessRuleService;
import execute.ExecuteService;

public class OracleBusinessRuleGenerator implements BusinessRuleGenerator {
    private BusinessRuleFacade businessRuleFacade = new OracleRuleFacade();

    public boolean execute(int businessRuleId) {
        String businessRuleCode = businessRuleFacade.getRuleCode(businessRuleId);

        return ExecuteService.execute(businessRuleId, businessRuleCode);
    }

    public boolean delete(int businessRuleId) {
        BusinessRule businessRule = new BusinessRuleService().getBusinessRule(businessRuleId);
        return businessRule.removeFromTargetDb();
    }

    public String example(int businessRuleId) {
        return businessRuleFacade.getRuleCode(businessRuleId);
    }
}
