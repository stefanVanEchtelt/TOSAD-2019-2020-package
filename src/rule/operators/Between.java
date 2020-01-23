package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

import java.util.List;

public class Between extends RuleDecorator {
    private Value from;
    private Value to;

    public Between(Rule rule, Value from, Value to) {
        super(rule);
        this.from = from;
        this.to = to;
    }

    public String create() {
        return super.create() + "(" + this.getColumn().getUsableName() + " between " + this.from.getUsableValue(this.getColumn().getTableName()) + " and " + this.to.getUsableValue(this.getColumn().getTableName()) + ")";
    }

    public List<String> getJoinableValues() {
        List<String> values = super.getJoinableValues();

        if (this.from.isColumn() && !super.isInBusinessRuleTable(this.from.getOfficialValue())) {
            if (!values.contains(this.from.getOfficialValue())) {
                values.add(this.from.getOfficialValue());
            }
        }

        if (this.to.isColumn() && !super.isInBusinessRuleTable(this.to.getOfficialValue())) {
            if (!values.contains(this.to.getOfficialValue())) {
                values.add(this.to.getOfficialValue());
            }
        }

        return values;
    }

    public static int getRuleTypeEid() {
        return 8;
    }
}
