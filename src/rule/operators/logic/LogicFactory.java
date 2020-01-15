package rule.operators.logic;

import rule.Rule;

public class LogicFactory {
    private int typeEid;
    private Rule rule;

    public LogicFactory(int typeEid, Rule rule) {
        this.typeEid = typeEid;
        this.rule = rule;
    }

    public Rule create() {
        // TODO fix this...
        if (true) {
            return new Or(rule);
        } else {
            return new Or(rule);
        }
    }
}
