import businessRule.BusinessRule;
import businessRule.BusinessRuleService;
import failure.Failure;
import failure.FailureService;
import rule.Rule;
import rule.RuleService;
import triggerType.TriggerType;
import triggerType.TriggerTypeService;

import java.util.List;

public class OracleRuleFacade implements BusinessRuleFacade {
    public String getRuleCode(int businessRuleId) {
        BusinessRuleBuilder businessRuleBuilder = new OracleBusinessRuleBuilder();

        // TODO find better way....
        BusinessRule businessRule = new BusinessRuleService().getBusinessRule(businessRuleId);
        List<TriggerType> triggerTypes = new TriggerTypeService().getByBusinessRule(businessRuleId);
        Rule rule = new RuleService().getRuleByBusinessRule(businessRule);
        Failure failure = new FailureService().getByBusinessRule(businessRuleId);

        businessRuleBuilder.buildHeader(businessRule.getName(), triggerTypes);
        businessRuleBuilder.buildBody(rule, failure);
        businessRuleBuilder.buildFailure(failure);

        return businessRuleBuilder.build();
    }
}
