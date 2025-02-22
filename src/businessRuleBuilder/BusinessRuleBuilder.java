package businessRuleBuilder;

import businessRule.BusinessRule;
import failure.Failure;
import rule.Rule;
import triggerType.TriggerType;

import java.util.List;

public interface BusinessRuleBuilder {
    public void buildHeader(BusinessRule businessRule, List<TriggerType> triggerTypes);
    public void buildDeclaration(Rule rule);
    public void buildJoins(Rule rule);
    public void buildBody(Rule rule);
    public void buildFailure(Failure exception);
    public String build();
}
