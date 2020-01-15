package rule;

import values.Column;

public class BasicRule implements Rule {
    private Column column;

    public BasicRule(Column column) {
        this.column = column;
    }

    public Column getColumn() {
        return this.column;
    }

    public String create() {
        return "";
    }
}
