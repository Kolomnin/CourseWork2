import java.time.LocalDateTime;

public class Task implements Repeatable {
    private String head;
    private String description;
    private final TaskType taskType;
    private final RepeatTape repeatTape;
    private final LocalDateTime dateTime;
    private final int id;
    private static int countId = 1;


    public Task(String head, String description, TaskType taskType,
                LocalDateTime dateTime, RepeatTape repeatTape) throws RuntimeException {
        setHeader(head);
        setDescription(description);
        this.taskType = taskType;
        this.dateTime = dateTime;
        this.repeatTape = repeatTape;
        this.id = countId++;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getHead() {
        return head;
    }

    public void setHeader(String header) throws RuntimeException {
        try {
            if (header == null || header.isBlank()) {
                throw new RuntimeException("Введите заголовок");
            } else {
                this.head = head;
            }
        } catch (RuntimeException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public void setDescription(String description) throws RuntimeException {
        try {
            if (description == null || description.isBlank()) {
                throw new RuntimeException("Заполнить описание");
            } else {
                this.description = description;
            }
        } catch (RuntimeException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    public TaskType getTaskType() {
        return taskType;
    }

    @Override
    public String toString() {
        return "Задача {" +
                "№ =" + id +
                ", заголовок ='" + head + '\'' +
                ", описание ='" + description + '\'' +
                ", тип задачи =" + taskType.getType() +
                ", дата =" + dateTime +
                ", " + repeatTape.getName() + nextTime() +
                '}';

    }

    @Override
    public RepeatTape nextTime() {
        switch (repeatTape) {
            case ONE_TIME -> System.out.println(dateTime.plusDays(0));
            case EVERYDAY -> System.out.println(dateTime.plusDays(1));
            case WEEKLY -> System.out.println(dateTime.plusWeeks(1));
            case MONTHLY -> System.out.println(dateTime.plusMonths(1));
            case ANNUAL -> System.out.println(dateTime.plusYears(1));
        }
        return repeatTape;
    }

}