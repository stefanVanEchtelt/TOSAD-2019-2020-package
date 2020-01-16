package rule.operators;

import rule.Rule;
import rule.RuleDecorator;

public class Not extends RuleDecorator {
    Not(Rule rule) {
        super(rule);
    }

    public String create() {
        return super.create() + "!";
    }

    public static int getRuleTypeEid() {
        return 2;
    }
}
