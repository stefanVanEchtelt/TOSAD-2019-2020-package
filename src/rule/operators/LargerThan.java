package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

public class LargerThan extends RuleDecorator {
    private Value larger;

    public LargerThan(Rule rule, Value larger) {
        super(rule);
        this.larger = larger;
    }

    public String create() {
        return super.create() + "(" + this.larger.getValue() + " < " + this.getColumn().getUsableName() + ")";
    }

    public static int getRuleTypeEid() {
        return 6;
    }
}
