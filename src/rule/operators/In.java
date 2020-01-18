package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

import java.util.List;

public class In extends RuleDecorator {
    private List<Value> values;

    public In(Rule rule, List<Value> values) {
        super(rule);
        this.values = values;
    }

    public String create() {
        return super.create() + "";
    }

    public static int getRuleTypeEid() {
        return 5;
    }
}
