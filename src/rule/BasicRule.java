package rule;

import businessRule.BusinessRule;
import value.Column;

import java.util.ArrayList;
import java.util.List;

public class BasicRule implements Rule {
    private Column column;
    private List<String> joinableValues = new ArrayList<String>();

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

    public List<String> getJoinableValues() {
        return this.joinableValues;
    }
}
