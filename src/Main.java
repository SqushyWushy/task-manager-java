import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args){
       TaskManager manager = new TaskManager();
       Scanner scanner = new Scanner(System.in);
       int userChoice;

       System.out.println("Welcome to your Task Manager!");

       do{
           System.out.println("\n1. Add a new task");
           System.out.println("2. See all tasks");
           System.out.println("3. Mark a task as complete");
           System.out.println("4. Quit");
           System.out.print("Choose an option: ");
           userChoice = scanner.nextInt();
           scanner.nextLine();

           if (userChoice == 1) {
               System.out.print("\nWhat task would you like to add? ");
               String userTask = scanner.nextLine();
               manager.addTask(userTask);
               System.out.println("The following task has been added:");
               System.out.printf("[✗] %s", userTask);
               System.out.println();
           }

           if (userChoice == 2){
               System.out.println("All tasks shown below: ");
               manager.showTasks();
           }

           if (userChoice == 3){
               manager.showTasks();
               System.out.print("Which task would you like to mark complete? ");
               int markComplete = scanner.nextInt();
               manager.completeTask(markComplete);
               manager.showTasks();
           }

       } while(userChoice != 4);
       scanner.close();
       }


   }
