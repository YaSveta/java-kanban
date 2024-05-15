package Schema;

public class Task {
    private String name;
    private String description;
    private Status status = Status.NEW;
    private static int id = 0;
    private final int taskId;

    //конструктор
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        taskId = createId();
    }

    //Обновление ID
    public static int createId() {
        return ++id;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        return this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", status = " + getStatus() +
                ", taskId = " + getTaskId() +
                '}' + "\n";
    }
}
