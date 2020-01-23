package rule;

import value.Column;

import java.util.List;

public interface Rule {
    public String create();
    public Column getColumn();
    public List<String> getJoinableValues();
}
