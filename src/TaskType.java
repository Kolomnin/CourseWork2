

public enum TaskType {
    PERSONAL("личная"),
    WORK("рабочая");

    private final String type;

    TaskType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
