package rule;

import businessRule.BusinessRule;
import value.Column;

public class BasicRule implements Rule {
    private Column column;

    public BasicRule(Column column) {
        this.column = column;
    }

    public Column getColumn() {
        return this.column;
    }

    public String create() {
        return "";
    }

    static Rule getRuleByBusinessRule(BusinessRule businessRule) {
        RuleStorage ruleStorage = new OracleRuleStorage();
        return ruleStorage.getRuleByBusinessRule(businessRule);
    }
}
