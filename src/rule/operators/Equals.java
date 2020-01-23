package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

import java.util.List;

public class Equals extends RuleDecorator {
    private Value equal;

    public Equals(Rule rule, Value equal) {
        super(rule);
        this.equal = equal;
    }

    public String create() {
        return super.create() + "(" + this.equal.getUsableValue(this.getColumn().getTableName()) + " = " + this.getColumn().getUsableName() + ")";
    }

    public List<String> getJoinableValues() {
        List<String> values = super.getJoinableValues();

        if (this.equal.isColumn() && !super.isInBusinessRuleTable(this.equal.getOfficialValue())) {
            if (!values.contains(this.equal.getOfficialValue())) {
                values.add(this.equal.getOfficialValue());
            }
        }

        return values;
    }

    public static int getRuleTypeEid() {
        return 3;
    }
}
