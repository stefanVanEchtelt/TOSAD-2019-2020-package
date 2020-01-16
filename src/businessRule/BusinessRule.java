package businessRule;

public class BusinessRule {
    private int id;
    private String name;
    private String onTable;
    private String onColumn;

    BusinessRule(int id, String name, String onTable, String onColumn) {
        this.id = id;
        this.name = name;
        this.onTable = onTable;
        this.onColumn = onColumn;
    }

    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }

    static BusinessRule getById(int businessRuleId) {
        BusinessRuleStorage businessRuleStorage = new BusinessRuleOracleStorage();
        return businessRuleStorage.getById(businessRuleId);
    }

    public String getTable() {
        return this.onTable;
    }
}
