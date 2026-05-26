import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

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
           System.out.println(i + 1 + ". [" + status + "] " + t.title);
        }
        if (tasks.isEmpty()){
            System.out.println("You have no tasks!");
        }
    }

    void completeTask(int index){
        tasks.get(index).completed = true;
    }

    void run(){
        loadTasks();
        Scanner scanner = new Scanner(System.in);
        int userChoice;

        System.out.println("Welcome to your Task Manager!");

        do{
            System.out.println("\n1. Add a new task");
            System.out.println("2. See all tasks");
            System.out.println("3. Mark a task as complete");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("INVALID INPUT.");
                scanner.nextLine();
                userChoice = 0;
            }

            if (userChoice == 1) {
                System.out.print("\nWhat task would you like to add? ");
                String userTask = scanner.nextLine();
                addTask(userTask);
                System.out.println("The following task has been added:");
                System.out.printf("[✗] %s", userTask);
                System.out.println();
            }

            else if (userChoice == 2){
                System.out.println("All tasks shown below: ");
                showTasks();
            }

            else if (userChoice == 3){
                showTasks();
                System.out.print("Which task would you like to mark complete? ");
                while (true) {
                    if (scanner.hasNextInt()) { // ask for input and expect int
                        int taskIndex = scanner.nextInt(); //passed the condition, it's an int, pull it out of buffer
                        scanner.nextLine(); // enter still in buffer, this gets rid of it, empties out the buffer
                        if (taskIndex >= 1 && taskIndex <= tasks.size()) { //we have our int BUT it needs to be valid
                            completeTask(taskIndex - 1); //it passed condition so yes its valid and we mark task as complete
                            showTasks(); //show tasks after completion
                            break; //get out of the loop
                        } else { //if the number is invalid, let the user know to try again
                            System.out.print("Invalid index. Try again: ");
                        }
                    } else { // if the scanner gets something that is not an int, tell the user to try again
                        System.out.print("Please enter a number. Try again: ");
                        scanner.nextLine();
                    }
                }
            }
            else if (userChoice == 4){
                System.out.println("Stay organized out there! Enjoy your day!");
                saveTasks();
            }
            else{
                System.out.println("Please enter a valid number.");
            }

        } while(userChoice != 4);
        scanner.close();
    }

    void saveTasks(){
        try{
            FileWriter writer = new FileWriter("tasks.txt");
            for (Task t : tasks){
                writer.write(t.title + "," + t.completed + "\n");
            }
            writer.close();
        } catch (IOException e){
            System.out.println("Error saving tasks.");
        }
    }

    void loadTasks(){
        try{
            File file = new File("tasks.txt");
            if (!file.exists()){
                return;
            }
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String title = parts[0];
                boolean completed = Boolean.parseBoolean(parts[1]);
                Task t = new Task(title);
                t.completed = completed;
                tasks.add(t);
            }

            fileScanner.close();

        } catch (IOException e){
            System.out.println("Error loadings tasks.");
        }
    }

    }
