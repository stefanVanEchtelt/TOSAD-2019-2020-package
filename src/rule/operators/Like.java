package rule.operators;

import rule.Rule;
import rule.RuleDecorator;
import value.Value;

import java.util.List;

public class Like extends RuleDecorator {
    private Value like;

    public Like(Rule rule, Value like) {
        super(rule);
        this.like = like;
    }

    public String create() {
        return super.create() + "(" + this.getColumn().getUsableName() + " like '%' + " + this.like.getUsableValue(this.getColumn().getTableName()) + " + '%')";
    }

    public List<String> getJoinableValues() {
        List<String> values = super.getJoinableValues();

        // decide witch value to join
        if (this.like.isColumn() && !super.isInBusinessRuleTable(this.like.getOfficialValue())) {
            if (!values.contains(this.like.getOfficialValue())) {
                values.add(this.like.getOfficialValue());
            }
        }

        return values;
    }

    public static int getRuleTypeEid() {
        return 9;
    }
}
