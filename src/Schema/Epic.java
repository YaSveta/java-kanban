package Schema;

public class Epic extends Task{
    public Epic(String name, String description) {
        super(name,description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name = '" + getName() + '\'' +
                ", description = '" + getDescription() + '\'' +
                ", status = " + getStatus() +
                ", taskId = " + getTaskId() +
                ", EpicId = " + getTaskId() +
                '}' + "\n";
    }
}
