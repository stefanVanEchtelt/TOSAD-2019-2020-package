package rule.operators;

import rule.Rule;
import rule.RuleDecorator;

public class Not extends RuleDecorator {
    public Not(Rule rule) {
        super(rule);
    }

    public String create() {
        return super.create() + "not";
    }

    public static int getRuleTypeEid() {
        return 2;
    }
}
