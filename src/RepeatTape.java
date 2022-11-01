

public enum RepeatTape {
    ONE_TIME("Без повтора"),
    EVERYDAY("Повтор завтра"),
    WEEKLY("Повтор через неделю"),
    MONTHLY("Повтор через месяц"),
    ANNUAL("Повтор через год");

    private final String name;

    RepeatTape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}