import businessRule.BusinessRule;
import businessRule.BusinessRuleOracleStorage;
import businessRule.BusinessRuleStorage;
import failure.Failure;
import failure.FailureOracleStorage;
import failure.FailureStorage;
import rule.Rule;
import rule.RuleOracleStorage;
import triggerType.TriggerType;
import triggerType.TriggerTypeOracleStorage;
import triggerType.TriggerTypeStorage;

import java.util.List;

public class BusinessRuleExecuteFacadeUsage implements BusinessRuleExecuteFacade {
    // TODO FIX SOMETHING FOR THE MAP STRUCTURE + removing those things...
    private BusinessRuleStorage businessRuleStorage = new BusinessRuleOracleStorage();
    private TriggerTypeStorage triggerTypeStorage = new TriggerTypeOracleStorage();
    private FailureStorage failureStorage = new FailureOracleStorage();
    private RuleOracleStorage ruleOracleStorage = new RuleOracleStorage();

    public boolean execute(int businessRuleId) {
        System.out.println("execute fac " + businessRuleId);

        String br = this.getBusinessRule(businessRuleId);
        System.out.println(br);

        return true;
    }

    public boolean example(int businessRuleId) {
        System.out.println("example fac " + businessRuleId);

        String br = this.getBusinessRule(businessRuleId);
        System.out.println(br);

        return true;
    }

    private String getBusinessRule(int businessRuleId) {
        // TODO can we do this better???
        BusinessRule businessRule = businessRuleStorage.getById(businessRuleId);
        List<TriggerType> trigger_event_types = triggerTypeStorage.getByBusinessRule(businessRuleId);
        Failure failure = failureStorage.getByBusinessRule(businessRuleId);
        Rule rule = ruleOracleStorage.getFullRuleByBusinessRule(businessRuleId);

        BusinessRuleBuilder businessRuleBuilder = new OracleBusinessRuleBuilder();
        businessRuleBuilder.buildHeader(businessRule.getName(), trigger_event_types);
        businessRuleBuilder.buildBody(rule, failure);
        businessRuleBuilder.buildFailure(failure);
        return businessRuleBuilder.build();
    }
}
