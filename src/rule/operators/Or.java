package rule.operators;

import rule.Rule;
import rule.RuleDecorator;

public class Or extends RuleDecorator {

    public Or(Rule rule) {
        super(rule);
    }

    public String create() {
        return super.create() + " or ";
    }
}
