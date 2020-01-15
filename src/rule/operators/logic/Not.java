package rule.operators.logic;

import rule.Rule;
import rule.RuleDecorator;

public class Not extends RuleDecorator {
    Not(Rule rule) {
        super(rule);
    }

    public String create() {
        return super.create() + "!";
    }
}
