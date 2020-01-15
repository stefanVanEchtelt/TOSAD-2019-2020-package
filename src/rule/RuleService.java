package rule;

import businessRule.BusinessRule;

public class RuleService {
    public Rule getRuleByBusinessRule(BusinessRule businessRule) {
        return BasicRule.getRuleByBusinessRule(businessRule);
    }
}
