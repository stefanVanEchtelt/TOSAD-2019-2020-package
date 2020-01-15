package businessRule;

public class BusinessRule {
    private int id;
    private String name;

    public BusinessRule(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
