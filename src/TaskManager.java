import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> tasks;

    TaskManager() {
        tasks = new ArrayList<>();
    }

    void addTask(String title){
        tasks.add(new Task(title));
    }

    void showTasks(){
        for(int i = 0; i < tasks.size(); i++){
           Task t = tasks.get(i);
           String status = t.completed ? "✓" : "✗";
           System.out.println(i + ". [" + status + "] " + t.title);
        }
    }

    void completeTask(int index){
        tasks.get(index).completed = true;
    }
}
