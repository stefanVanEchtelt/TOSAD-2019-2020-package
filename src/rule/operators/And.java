package rule.operators;

import rule.Rule;
import rule.RuleDecorator;

public class And extends RuleDecorator {

    public And(Rule rule) {
        super(rule);
    }

    public String create() {
        return super.create() + " and ";
    }

    public static int getRuleTypeEid() {
        return 7;
    }
}
