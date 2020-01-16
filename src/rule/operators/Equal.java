package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

public class Equal extends RuleDecorator {
    private Value equal;

    public Equal(Rule rule, Value equal) {
        super(rule);
        this.equal = equal;
    }

    public String create() {
        return super.create() + "(" + this.equal.getValue() + " = " + this.getColumn().getNameWithTable() + ")";
    }
}
