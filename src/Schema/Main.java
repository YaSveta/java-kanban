package Schema;

import Manage.TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        //--------------------------------TASKS----------------------------------------------
  /*      Task task1 = new Task("Упаковка вещей","Переезд");
        Task task2 = new Task("Решить задачу","Обучение на курсе SQL");
        Task task3 = new Task("Посмотреть новый фильм","Сходить в кино на новый фильм");
        //d. Создание. Сам объект должен передаваться в качестве параметра.
        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);
        //Проверяем созданные объекты
        print("Проверяем созданные объекты");
        printTasks(taskManager);
        //Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
        print("Проверяем обновление тасков");
        taskManager.changeTaskStatus(task2,Status.IN_PROGRESS);
        // + name
        taskManager.updateTaskName(task1,"Упаковать вещи");
        // + description
        taskManager.updateTaskDescr(task3,"Сходить в кино");
        //a. Получение списка всех задач.
        taskManager.getAllTasks();
        //f. Удаление по идентификатору.
        print("Удаление по идентификатору");
        taskManager.removeTaskById(1);
        printTasks(taskManager);
        //c. Получение по идентификатору
        print("Получение по идентификатору");
        taskManager.getTaskById(2);
        printTasks(taskManager);
        //b. Удаление всех задач.
        print("Удаление всех задач");
        taskManager.removeAllTasks();
        printTasks(taskManager);*/


        //--------------------------------EPICS & SUBTASKS-------------------------------------------
        //Создаем пустой эпик
        Epic epic1 = new Epic("Переезд","Список дел для подготовки к переезду");
        Epic epic2 = new Epic("План активностей и отдыха на май","Список задач на месяц");
        taskManager.createEpic(epic1);
        taskManager.createEpic(epic2);
        //Привязываем к эпику подзадачи
        Subtask subtask1 = new Subtask("Купить билеты","Подготовка к отпуску - этап 1",1);
        Subtask subtask2 = new Subtask("Сборка чемодана","Подготовка к отпуску - этап 2",1);
        Subtask subtask3 = new Subtask("Сбор документов","Подготовка к отпуску - этап 3",1);
        Subtask subtask4 = new Subtask("Купить блокнот для записи планов","Планы на месяц май",2);
        //d. Создание. Сам объект должен передаваться в качестве параметра.
        taskManager.createSubTask(subtask1);
        taskManager.createSubTask(subtask2);
        taskManager.createSubTask(subtask3);
        taskManager.createSubTask(subtask4);
        /*print("Вывод всех подзадач");
        printSubTasks(taskManager);
        //Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
        print("Проверяем обновление сабтасков");
        taskManager.changeSubTaskStatus(subtask1,Status.IN_PROGRESS);
        // + name
        taskManager.updateSubTaskName(subtask1,"Найти подходящее время вылета");
        // + description
        taskManager.updateSubTaskDescr(subtask1,"Найти и купить илеты");
        //a. Получение списка всех задач.
        taskManager.getAllSubTasks();
        //f. Удаление по идентификатору.
        //print("Удаление по идентификатору");
        //taskManager.removeSubTaskById(1);
        printSubTasks(taskManager);
        //c. Получение по идентификатору
        print("Получение по идентификатору");
        taskManager.getSubTaskById(2);*/
        //b. Удаление всех задач.
        //print("Удаление всех задач");
        //taskManager.removeAllSubTasks();
        //printSubTasks(taskManager);

        print("Получение всех подзадач в рамках одного эпика (тест 1)");
        taskManager.getTaskbyEpic(epic1);
        print("Получение всех подзадач в рамках одного эпика (тест 2)");
        taskManager.getTaskbyEpic(epic2);
//        print("Вывод всех подзадач");
        //printSubTasks(taskManager);
        print("Вывод всех эпиков");
        taskManager.getAllEpics();




    }

    public static void print(String text){
        System.out.println(text);
    }
    public static void printTasks(TaskManager taskManager){
        taskManager.getAllTasks();
    }
    public static void printSubTasks(TaskManager taskManager){
        taskManager.getAllSubTasks();
    }
}
