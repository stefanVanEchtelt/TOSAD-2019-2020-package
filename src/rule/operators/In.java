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
        String inString = "";
        for (Value value: this.values) {
            inString += value.getValue();
            if (this.values.indexOf(value) < this.values.size() - 1) {
                inString += ", ";
            }
        }

        return super.create() + this.getColumn().getUsableName() + " in (" + inString + ")";
    }

    public static int getRuleTypeEid() {
        return 5;
    }
}
