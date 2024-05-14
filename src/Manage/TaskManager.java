package Manage;

import Schema.Epic;
import Schema.Status;
import Schema.Subtask;
import Schema.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    Map <Integer, Task> tasks = new HashMap<>();
    Map <Integer, Epic> epics = new HashMap<>();
    Map <Integer, Subtask> subTasks = new HashMap<>();

    Map <Subtask,Integer > epicTasks = new HashMap<>();
    //List <Integer> listId = new ArrayList<>();

    //Создать задачу/подзадачу/Эпик
    public void createTask(Task task){
        int id = task.getTaskId();
        tasks.put(id,task);
    }
    public void createSubTask(Subtask subTask){
        int id = subTask.getTaskId();
        subTasks.put(id,subTask);
        //Создаем связанный hash Map через список
        //listId.add(id);
        epicTasks.put(subTask,subTask.getEpicId());
        //System.out.println("epicTasks_CHECK " + subTask.getEpicId());
        //System.out.println("MAP epicTasks " + epicTasks);
    }
    public void createEpic(Epic epic){
        int id = epic.getTaskId();
        epics.put(id,epic);
    }

    //Обновить название задачи/подзадачи/эпика
    public void updateTaskName(Task task, String name){
        task.setName(name);
    }
    public void updateSubTaskName(Subtask subTask, String name){
        subTask.setName(name);
    }
    public void updateEpicName(Epic epic, String name){
        epic.setName(name);
    }

    //Обновить название задачи/подзадачи/эпика
    public void updateTaskDescr(Task task, String description){
        task.setDescription(description);
    }
    public void updateSubTaskDescr(Subtask subTask, String description){
        subTask.setDescription(description);
    }
    //Обновить статус задачи/подзадачи/эпика
    public void changeTaskStatus(Task task, Status status){
        task.setStatus(status);
    }
    public void changeSubTaskStatus(Subtask subTask, Status status){
        subTask.setStatus(status);
    }

    //Получить задачу/подзадачу/эпик по идентификатору
    public void getTaskById(int id){
        System.out.println(tasks.get(id));
    }
    public void getSubTaskById(int id){
        System.out.println(subTasks.get(id));
    }

    // Получить перечень всех задач/подзадач/эпика
    public void getAllTasks(){
        System.out.println(tasks);
    }
    public void getAllSubTasks(){
        System.out.println(subTasks);
    }
    public void getAllEpics(){
        System.out.println(epics);
    }

    //Удалить все задачи/подзадачи/эпики
    public void removeAllTasks(){
        tasks.clear();
    }
    public void removeAllSubTasks(){
        subTasks.clear();
    }

    //Удалить задачу/подзадачу/эпик по идентификатору
    public void removeTaskById(int id){
        tasks.remove(id);
    }
    public void removeSubTaskById(int id){
        subTasks.remove(id);
    }

     //Получить список всех задач в рамках эпика
    public void getTaskbyEpic(Epic epic){
        //System.out.println(epicTasks.get(epic.getTaskId()));
        //System.out.println(epicTasks);
        //System.out.println(epic.getTaskId());
//        System.out.println(epicTasks.keySet());
//        System.out.println(epicTasks.values());
        //System.out.println("MAP epicTasks " + epicTasks);
        Integer epicId = epic.getTaskId();
        for (Map.Entry<Subtask, Integer> entry : epicTasks.entrySet()) {
            Subtask key = entry.getKey();
            Integer value = entry.getValue();
            //System.out.println("Key: " + key + ", Value: " + value);
            if (epicId.equals(value)){
                System.out.println(key);
            }
        }


    }

}
