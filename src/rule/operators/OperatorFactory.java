package rule.operators;

import rule.BasicRule;
import rule.Rule;
import values.Value;
import rule.operators.logic.LogicFactory;
import values.Column;

import java.util.List;

public class OperatorFactory {
    private int typeEid;
    private List<Value> values;
    private Rule rule;

    public OperatorFactory(int typeEid, List<Value> values, Rule rule) {
        this.typeEid = typeEid;
        this.values = values;
        this.rule = rule;
    }

    public Rule create() {
        if (values.size() <= 0) {
            return new LogicFactory(this.typeEid, this.rule).create();
        } else {
            return new BasicRule(new Column("x"));
        }
    }
}
