package rule.operators.logic;

import rule.Rule;
import rule.RuleDecorator;

public class Or extends RuleDecorator {

    Or(Rule rule) {
        super(rule);
    }

    public String create() {
        return super.create() + " or ";
    }
}
