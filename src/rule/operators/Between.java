package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

public class Between extends RuleDecorator {
    private Value from;
    private Value to;

    public Between(Rule rule, Value from, Value to) {
        super(rule);
        this.from = from;
        this.to = to;
    }

    public String create() {
        return super.create() + "(" + this.getColumn().getUsableName() + " between " + this.from.getValue() + " and " + this.to.getValue() + ")";
    }

    public static int getRuleTypeEid() {
        return 8;
    }
}
