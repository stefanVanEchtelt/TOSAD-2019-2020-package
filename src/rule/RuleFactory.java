package rule;

import rule.operators.Equal;
import rule.operators.LessThan;
import rule.operators.Or;
import value.Literal;
import value.Value;

public class RuleFactory implements RuleFactoryInterface {
    private Rule rule;
    private int ruleTypeEid;

    RuleFactory(Rule rule, int ruleTypeEid) {
        this.rule = rule;
        this.ruleTypeEid = ruleTypeEid;
    }

    public Rule create() {
        // TODO FIX THIS ....

        Value value = new Literal("12");
        if (this.ruleTypeEid == 3) {
            return new Equal(this.rule, value);
        } else if (this.ruleTypeEid == 4) {
            return new LessThan(this.rule, value);
        } else {
            return new Or(this.rule);
        }
    }
}
