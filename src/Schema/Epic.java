package Schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Epic extends Task {

    List<Subtask> listTasks = new ArrayList<>();
    ArrayList<Status> SubtaskStatus = new ArrayList<>();

    public int counterDone = 0;
    public int counterNew = 0;
    public int counterProgress = 0;

    public List getListTasks() {
        return listTasks;
    }

    public ArrayList getSubtaskStatus() {
        return SubtaskStatus;
    }

    public void setListTask(Subtask subtask) {
        listTasks.add(subtask);
    }

    public ArrayList setSubtaskStatus() {
        return SubtaskStatus;
    }

    public Epic(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name = '" + getName() + '\'' +
                ", description = '" + getDescription() + '\'' +
                ", status = " + getStatus() +
                ", taskId = " + getTaskId() +
                ", EpicId = " + getTaskId() +
                '}' + "\n";
    }
}
