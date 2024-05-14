package Schema;

public class Subtask extends Task {

    private final int EpicId;

    public Subtask(String name, String description, int EpicId) {
        super(name,description);
        this.EpicId = EpicId;
    }


    public int getEpicId(){
      return EpicId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name = '" + getName() + '\'' +
                ", description = '" + getDescription() + '\'' +
                ", status = " + getStatus() +
                ", taskId = " + getTaskId() +
                ", EpicId = " + getEpicId() +
                '}' + "\n";
    }
}
