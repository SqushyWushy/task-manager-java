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
           System.out.println(userChoice);
           scanner.nextLine();

           if (userChoice == 1) {
               System.out.print("\nWhat task would you like to add? ");
               String userTask = scanner.nextLine();
               manager.addTask(userTask);
               System.out.println("The following task has been added:");
               System.out.printf("[] %s", userTask);
               System.out.println();
           }

       } while(userChoice != 4);



       }

   }
