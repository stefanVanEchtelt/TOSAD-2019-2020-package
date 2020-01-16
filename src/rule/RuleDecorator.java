package rule;

import value.Column;

public abstract class RuleDecorator implements Rule {
    protected Rule rule;

    public RuleDecorator(Rule rule) {
        this.rule = rule;
    }

    public Column getColumn() {
        return this.rule.getColumn();
    }

    public String create() {
        return this.rule.create();
    }
}
