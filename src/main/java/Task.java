public class Task {
    private String taskName;
    private boolean taskCompleted;

    public Task(String taskName) {
        this.taskName = taskName;
        this.taskCompleted = false;
    }

    public String completeTask() {
        this.taskCompleted = true;
        return returnTask();
    }

    public String returnTask() {
        if (taskCompleted) {
            return "[✓] " + taskName;
        } else {
            return "[✗] " + taskName;
        }
    }
}
