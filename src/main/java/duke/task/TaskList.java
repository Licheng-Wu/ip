package duke.task;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import duke.ui.Ui;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> todoList;
    private Ui ui;

    public TaskList() {
        this.todoList = new ArrayList<>();
        this.ui = new Ui();
    }

    public void list() {
        this.ui.generateDivider();
        for (int i = 0; i < todoList.size(); i++) {
            int index = i + 1;
            this.ui.generateLeftPadding();
            System.out.println(index + ". " + todoList.get(i).toString());
        }
        this.ui.generateDivider();
    }

    public Task get(int index) {
        return this.todoList.get(index);
    }

    public void remove(int index) {
        this.todoList.remove(index);
    }

    public int getSize() {
        return this.todoList.size();
    }

    public ArrayList<Task> getList() {
        return this.todoList;
    }

    public void addTodo(String isCompleted, String task) {
        Todo newTodo = new Todo(isCompleted, task);
        this.todoList.add(newTodo);
    }

    public void addDeadline(String isCompleted, String task, String deadline) {
        Deadline newDeadline = new Deadline(isCompleted, task, deadline);
        this.todoList.add(newDeadline);
    }

    public void addEvent(String isCompleted, String task, String eventDate) {
        Event newEvent = new Event(isCompleted, task, eventDate);
        this.todoList.add(newEvent);
    }

    public void find(String keyword) {
        ArrayList<Task> tempArrayList = new ArrayList<>();
        for (Task task : this.todoList) {
            String taskDetails = task.toString();
            if (taskDetails.contains(keyword)) {
                tempArrayList.add(task);
            }
        }
        this.ui.printMatchingTasks(tempArrayList);
    }

    public ArrayList<Task> findForGui(String keyword) {
        ArrayList<Task> tempArrayList = new ArrayList<>();
        for (Task task : this.todoList) {
            String taskDetails = task.toString();
            if (taskDetails.contains(keyword)) {
                tempArrayList.add(task);
            }
        }
        return tempArrayList;
    }
}
