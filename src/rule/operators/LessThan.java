package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

import java.util.List;

public class LessThan extends RuleDecorator {
    private Value less;

    public LessThan(Rule rule, Value less) {
        super(rule);
        this.less = less;
    }

    public String create() {
        return super.create() + "(" + this.less.getUsableValue(this.getColumn().getTableName()) + " > " + this.getColumn().getUsableName() + ")";
    }

    public List<String> getJoinableValues() {
        List<String> values = super.getJoinableValues();

        // decide witch value to join
        if (this.less.isColumn() && !super.isInBusinessRuleTable(this.less.getOfficialValue())) {
            if (!values.contains(this.less.getOfficialValue())) {
            values.add(this.less.getOfficialValue());
            }
        }

        return values;
    }

    public static int getRuleTypeEid() {
        return 4;
    }
}
