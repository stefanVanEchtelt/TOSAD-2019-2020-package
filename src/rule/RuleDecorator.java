package rule;

import value.Column;

import java.util.List;

public abstract class RuleDecorator implements Rule {
    protected Rule rule;

    public RuleDecorator(Rule rule) {
        this.rule = rule;
    }

    public List<String> getJoinableValues() {
        return this.rule.getJoinableValues();
    }

    public Column getColumn() {
        return this.rule.getColumn();
    }

    public String create() {
        return this.rule.create();
    }

    protected boolean isInBusinessRuleTable(String value) {
        String[] splitValue = value.split("\\.", value.length());

        if (!this.rule.getColumn().getTableName().equals(splitValue[0])) {
            return false;
        }

        return true;
    }
}
