package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

public class Equals extends RuleDecorator {
    private Value equal;

    public Equals(Rule rule, Value equal) {
        super(rule);
        this.equal = equal;
    }

    public String create() {
        return super.create() + "(" + this.equal.getValue() + " = " + this.getColumn().getUsableName() + ")";
    }

    public static int getRuleTypeEid() {
        return 3;
    }
}
