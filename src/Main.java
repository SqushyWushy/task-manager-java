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
               manager.addTask(userTask);
               System.out.println("The following task has been added:");
               System.out.printf("[✗] %s", userTask);
               System.out.println();
           }

           else if (userChoice == 2){
               System.out.println("All tasks shown below: ");
               manager.showTasks();
           }

           else if (userChoice == 3){
               manager.showTasks();
               System.out.print("Which task would you like to mark complete? ");
               while (true) {
                   if (scanner.hasNextInt()) { // ask for input and expect int
                       int taskIndex = scanner.nextInt(); //passed the condition, it's an int, pull it out of buffer
                       scanner.nextLine(); // enter still in buffer, this gets rid of it, empties out the buffer
                       if (taskIndex >= 1 && taskIndex <= manager.tasks.size()) { //we have our int BUT it needs to be valid
                           manager.completeTask(taskIndex - 1); //it passed condition so yes its valid and we mark task as complete
                           manager.showTasks(); //show tasks after completion
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
           }
           else{
               System.out.println("Please enter a valid number.");
           }

       } while(userChoice != 4);
       scanner.close();
       }


   }
