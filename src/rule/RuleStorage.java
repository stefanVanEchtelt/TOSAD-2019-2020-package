package rule;

import businessRule.BusinessRule;

public interface RuleStorage {
    public Rule getRuleByBusinessRule(BusinessRule businessRule);
}
