package businessRule;

public class BusinessRule {
    private int id;
    private String name;

    BusinessRule(int id, String name) {
        this.id = id;
        this.name = name;
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
}
