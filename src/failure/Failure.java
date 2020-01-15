package failure;

public class Failure {
    private int id;
    private String name;
    private int code;
    private String message;

    Failure(int id, String name, int code, String message) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.message = message;
    }

    Failure(String name, int code, String message) {
        this.name = name;
        this.code = code;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
