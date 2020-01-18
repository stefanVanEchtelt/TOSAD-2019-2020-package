package rule;

import rule.operators.Equals;
import rule.operators.LessThan;
import rule.operators.Not;
import rule.operators.Or;
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
        }

        return rule;
    }
}
