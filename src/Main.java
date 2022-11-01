import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        TaskManager taskManager = new TaskManager();

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: \n");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, taskManager);
                            break;
                        case 2:
                            delTask(scanner, taskManager);
                            break;
                        case 3:
                            getTaskDate(scanner, taskManager);
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void inputTask(Scanner scanner, TaskManager taskManager) throws RuntimeException {

        String head = scanner.nextLine();
        System.out.print("Введите описание задачи: \n");
        String description = scanner.nextLine();
        System.out.print("Выберите тип задачи: ");
        System.out.println("""
                \nPERSONAL - личная,
                WORK - рабочая.
                """);
        try {
            TaskType taskType = TaskType.valueOf(scanner.next());
            System.out.println("Введите дату YYYY-MM-DD и время hh:mm : ");
            LocalDate dateTask = LocalDate.parse(scanner.next());
            LocalTime timeTask = LocalTime.parse(scanner.next());
            System.out.println("Выберете повторяемость:");
            System.out.println("""
                    ONE_TIME - однократная задача,
                    EVERYDAY - ежедневная задача,
                    WEEKLY - еженедельная задача,
                    MONTHLY - ежемесячная задача,
                    ANNUAL - ежегодная задача.
                                        
                    """);
            RepeatTape repeatTape = RepeatTape.valueOf(scanner.next());
            LocalDateTime dateTime = LocalDateTime.of(dateTask, timeTask);
            taskManager.addTask(new Task(head, description, taskType, dateTime, repeatTape));
        } catch (RuntimeException e) {
            System.out.println("Необходимо ввести в правильном формате дату YYYY-MM-DD и время hh:mm");
        }
    }

    private static void delTask(Scanner scanner, TaskManager taskManager) {
        System.out.println("Введине номер задачи: \n");
        int id = scanner.nextInt();
        taskManager.removeTask(id);
    }

    private static void getTaskDate(Scanner scanner, TaskManager taskManager) {
        System.out.println("Получить задачи на указанный день: ");
        LocalDate dateTask = LocalDate.parse(scanner.next());
        taskManager.getTaskDate(dateTask);
    }

    private static void printMenu() {
        System.out.println("""
                1. Добавить задачу
                2. Удалить задачу
                3. Получить задачи на указанный день
                0. Выход
                """);
    }
}