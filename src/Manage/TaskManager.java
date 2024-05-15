package Manage;

import Schema.Epic;
import Schema.Status;
import Schema.Subtask;
import Schema.Task;

import java.util.*;

public class TaskManager {

    Map<Integer, Task> tasks = new HashMap<>();
    Map<Integer, Epic> epics = new HashMap<>();
    Map<Integer, Subtask> subTasks = new HashMap<>();
    Map<Integer, List> epicTasks = new HashMap<>();


    //Создать задачу/подзадачу/Эпик
    public void createTask(Task task) {
        int id = task.getTaskId();
        tasks.put(id, task);
    }

    public void createSubTask(Subtask subTask) {
        int id = subTask.getTaskId();
        subTasks.put(id, subTask);
        int epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);
        epic.counterNew++;
        epic.setListTask(subTask);
    }

    public void createEpic(Epic epic) {
        int id = epic.getTaskId();
        epics.put(id, epic);
        System.out.println("epicTasks: " + epicTasks);
    }

    //Обновить задачи/подзадачи/эпик
    public void updateTask(Task task, String name, String description, Status status) {
        task.setName(name);
        task.setDescription(description);
        task.setStatus(status);
    }

    public void updateSubTask(Subtask subTask, String name, String description, Status status) {
        boolean isNeedCountStatus = !status.equals(subTask.getStatus());
        subTask.setName(name);
        subTask.setDescription(description);
        subTask.setStatus(status);
        Epic epic = getEpic(subTask);

        if (isNeedCountStatus) {
            switch (status) {
                case IN_PROGRESS -> {
                    epic.counterNew--;
                    epic.counterProgress++;
                }
                case DONE -> {
                    epic.counterDone++;
                    epic.counterProgress--;
                }
            }
        }
        //обновляем статус эпика
        updateEpicStatus(epic);
    }

    public void updateEpic(Epic epic, String name, String description) {
        epic.setName(name);
        epic.setDescription(description);
    }

    public void updateEpicStatus(Epic epic) {
        if (epic.counterNew > 0 && epic.counterProgress <= 0 && epic.counterDone <= 0) {
            epic.setStatus(Status.NEW);
        } else if (epic.counterNew <= 0 && epic.counterProgress <= 0 && epic.counterDone > 0) {
            epic.setStatus(Status.DONE);
        } else
            epic.setStatus(Status.IN_PROGRESS);
        System.out.println(epic.getStatus());
    }

    //Получить эпик
    public Epic getEpic(Subtask subTask) {
        int epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);
        return epic;
    }

    //Получить задачу/подзадачу/эпик по идентификатору
    public void getTaskById(int id) {
        System.out.println(tasks.get(id));
    }

    public void getSubTaskById(int id) {
        System.out.println(subTasks.get(id));
    }

    public void getEpicById(int id) {
        System.out.println(epics.get(id));
    }

    // Получить перечень всех задач/подзадач/эпика
    public void getAllTasks() {
        System.out.println(tasks);
    }

    public void getAllSubTasks() {
        System.out.println(subTasks);
    }

    public void getAllEpics() {
        System.out.println(epics);
    }

    //Удалить все задачи/подзадачи/эпики
    public void removeAllTasks() {
        tasks.clear();
    }

    public void removeAllSubTasks() {
        subTasks.clear();
    }

    //Удалить задачу/подзадачу/эпик по идентификатору
    public void removeTaskById(int id) {
        tasks.remove(id);
    }

    public void removeSubTaskById(int id) {
        subTasks.remove(id);
    }

    //Получить список всех задач в рамках эпика
    public void getTaskbyEpic(Epic epic) {
        System.out.println(epic.getListTasks());
    }

}
