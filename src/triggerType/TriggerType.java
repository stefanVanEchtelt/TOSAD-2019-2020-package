package triggerType;

public class TriggerType {
    private int id;
    private String name;

    public TriggerType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TriggerType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
