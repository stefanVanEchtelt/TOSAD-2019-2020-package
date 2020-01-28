package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

import java.util.List;

public class LargerThan extends RuleDecorator {
    private Value larger;

    public LargerThan(Rule rule, Value larger) {
        super(rule);
        this.larger = larger;
    }

    public String create() {
        return super.create() + "(" + this.larger.getUsableValue(this.getColumn().getTableName()) + " < " + this.getColumn().getUsableName() + ")";
    }

    public List<String> getJoinableValues() {
        List<String> values = super.getJoinableValues();

        // decide witch value to join
        if (this.larger.isColumn() && !super.isInBusinessRuleTable(this.larger.getOfficialValue())) {
            if (!values.contains(this.larger.getOfficialValue())) {
            values.add(this.larger.getOfficialValue());
            }
        }

        return values;
    }

    public static int getRuleTypeEid() {
        return 6;
    }
}
