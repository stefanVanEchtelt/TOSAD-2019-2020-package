package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

public class Like extends RuleDecorator {
    private Value like;

    public Like(Rule rule, Value like) {
        super(rule);
        this.like = like;
    }

    public String create() {
        return super.create() + "(" + this.getColumn().getUsableName() + " like '%' + " + this.like.getValue() + " + '%')";
    }

    public static int getRuleTypeEid() {
        return 9;
    }
}
