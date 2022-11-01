import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskManager {
    private final Map<Integer, Task> taskMap;

    public TaskManager() {
        this.taskMap = new LinkedHashMap<>();

    }

    public void addTask(Task task) throws RuntimeException {
        try {
            if (taskMap.containsKey(task.getId())) {
                throw new RuntimeException("Задача повторяется");
            } else {
                taskMap.put(task.getId(), task);
            }
        } catch (RuntimeException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    public void removeTask(int id) {
        taskMap.remove(id);
    }

    public void getTaskDate(LocalDate localDate) {
        for (Task value : taskMap.values()) {
            if (value.getDateTime().toLocalDate().equals(localDate)) {
                System.out.println(value);
            }
        }
    }
}
