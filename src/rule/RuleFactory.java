package rule;

import rule.operators.*;
import value.Value;
import value.ValueService;

import java.util.List;

public class RuleFactory implements RuleFactoryInterface {
    private Rule rule;
    private int ruleTypeEid;
    private int ruleId;

    RuleFactory(Rule rule, int ruleTypeEid, int ruleId) {
        this.rule = rule;
        this.ruleTypeEid = ruleTypeEid;
        this.ruleId = ruleId;
    }

    public Rule create() {
        List<Value> values = new ValueService().getValuesByRule(this.ruleId);
        Rule rule = null;

        if (this.ruleTypeEid == Or.getRuleTypeEid()) {
            rule = new Or(this.rule);

        } else if (this.ruleTypeEid == Not.getRuleTypeEid()) {
            rule = new Not(this.rule);

        } else if (this.ruleTypeEid == Equals.getRuleTypeEid()) {
            rule = new Equals(this.rule, values.get(0));

        } else if (this.ruleTypeEid == LessThan.getRuleTypeEid()) {
            rule = new LessThan(this.rule, values.get(0));

        } else if (this.ruleTypeEid == In.getRuleTypeEid()) {
            rule = new In(this.rule, values);

        } else if (this.ruleTypeEid == LargerThan.getRuleTypeEid()) {
            rule = new LargerThan(this.rule, values.get(0));

        } else if (this.ruleTypeEid == Between.getRuleTypeEid()) {
            rule = new Between(this.rule, values.get(0), values.get(1));

        } else if (this.ruleTypeEid == Like.getRuleTypeEid()) {
            rule = new Like(this.rule, values.get(0));

        }

        return rule;
    }
}
