package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

public class LessThan extends RuleDecorator {
    private Value less;

    public LessThan(Rule rule, Value less) {
        super(rule);
        this.less = less;
    }

    public String create() {
        return super.create() + "(" + this.less.getValue() + " > " + "col1" + ")";
    }
}
