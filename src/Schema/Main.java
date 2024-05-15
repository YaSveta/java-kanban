package Schema;

import Manage.TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        //--------------------------------TASKS----------------------------------------------
        /*Task task1 = new Task("Упаковка вещей","Переезд");
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
        taskManager.updateTask(task2,"Решить задачу","Обучение на курсе SQL",Status.IN_PROGRESS);
        taskManager.updateTask(task1,"Упаковать вещи","Переезд",Status.IN_PROGRESS);
        taskManager.updateTask(task3,"Посмотреть новый фильм","Сходить в кино",Status.IN_PROGRESS);
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
        printTasks(taskManager);
*/

        //--------------------------------EPICS & SUBTASKS-------------------------------------------
        //Создаем пустой эпик
        Epic epic1 = new Epic("Переезд", "Список дел для подготовки к переезду");
        Epic epic2 = new Epic("План активностей и отдыха на май", "Список задач на месяц");
        taskManager.createEpic(epic1);
        taskManager.createEpic(epic2);
        //Привязываем к эпику подзадачи
        Subtask subtask1 = new Subtask("Купить билеты", "Подготовка к отпуску - этап 1", 1);
        Subtask subtask2 = new Subtask("Сборка чемодана", "Подготовка к отпуску - этап 2", 1);
        Subtask subtask3 = new Subtask("Сбор документов", "Подготовка к отпуску - этап 3", 1);
        Subtask subtask4 = new Subtask("Купить блокнот для записи планов", "Планы на месяц май", 2);
        //d. Создание. Сам объект должен передаваться в качестве параметра.
/*        taskManager.createSubTask(subtask1,epic1);
        taskManager.createSubTask(subtask2,epic1);
        taskManager.createSubTask(subtask3,epic1);
        taskManager.createSubTask(subtask4,epic2);*/
        taskManager.createSubTask(subtask1);
        taskManager.createSubTask(subtask2);
        taskManager.createSubTask(subtask3);
        taskManager.createSubTask(subtask4);
        print("Вывод всех подзадач");
        printSubTasks(taskManager);
        //Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
        print("Проверяем обновление сабтасков (1)");
        taskManager.updateSubTask(subtask1, "Найти подходящее время вылета", "Найти и купить билеты", Status.NEW);
        taskManager.updateSubTask(subtask2, "Сборка чемодана", "Подготовка к отпуску - этап 2", Status.IN_PROGRESS);
        taskManager.updateSubTask(subtask3, "Сбор документов", "Подготовка к отпуску - этап 3", Status.IN_PROGRESS);
        print("Проверяем обновление сабтасков (2)");
        taskManager.updateSubTask(subtask1, "Найти подходящее время вылета", "Найти и купить билеты", Status.IN_PROGRESS);
        taskManager.updateSubTask(subtask2, "Сборка чемодана", "Подготовка к отпуску - этап 2", Status.DONE);
        taskManager.updateSubTask(subtask3, "Сбор документов", "Подготовка к отпуску - этап 3", Status.IN_PROGRESS);
        print("Проверяем обновление сабтасков (3)");
        taskManager.updateSubTask(subtask1, "Найти подходящее время вылета", "Найти и купить билеты", Status.DONE);
        taskManager.updateSubTask(subtask2, "Сборка чемодана", "Подготовка к отпуску - этап 2", Status.DONE);
        taskManager.updateSubTask(subtask3, "Сбор документов", "Подготовка к отпуску - этап 3", Status.DONE);
        //a. Получение списка всех задач.

        taskManager.getAllSubTasks();
        //f. Удаление по идентификатору.
        //print("Удаление по идентификатору");
        //taskManager.removeSubTaskById(1);
        printSubTasks(taskManager);
        //c. Получение по идентификатору
        print("Получение по идентификатору");
        taskManager.getSubTaskById(6);
        //b. Удаление всех задач.
        //print("Удаление всех задач");
        //taskManager.removeAllSubTasks();
        //printSubTasks(taskManager);
        print("Получение всех подзадач в рамках одного эпика (тест 1)");
        taskManager.getTaskbyEpic(epic1);
        print("Получение всех подзадач в рамках одного эпика (тест 2)");
        taskManager.getTaskbyEpic(epic2);
        //print("Вывод всех подзадач");
        //printSubTasks(taskManager);
        print("Вывод всех эпиков");
        taskManager.getAllEpics();
        print("обновление эпика");
        taskManager.updateEpic(epic1, "Переезд", "Список дел для подготовки к переезду");


    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printTasks(TaskManager taskManager) {
        taskManager.getAllTasks();
    }

    public static void printSubTasks(TaskManager taskManager) {
        taskManager.getAllSubTasks();
    }
}
