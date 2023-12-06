package Admin_Task_Management_System;


import java.sql.SQLException;
import java.util.Scanner;

public class TaskMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================================   *     TASK MANAGEMENT SYSTEM   *   ==============================================");

        // Create an instance of TaskDao
        TaskDao taskDao = new TaskDaoImplementation();

        // Pass the TaskDao instance to the TaskService constructor
        TaskService taskService = new TaskService(taskDao);
        
             // Get user's role
        String userRole;
        String choice;
        
     // Admin credentials
        String adminUsername = "admin";
        String adminPassword = "admin@123";

        // Authentication loop for admin login
        while (true) {
        	    System.out.println("         Login details of the Admin.....    ");
        	System.out.println("                                                                                                                                      ");
            
        	System.out.println("Enter admin username:");
            String enteredUsername = sc.next();
            System.out.println("                                                                                                                                      ");

            System.out.println("Enter admin password:");
            String enteredPassword = sc.next();
            System.out.println("                                                                                                                                      ");

            if (enteredUsername.equals(adminUsername) && enteredPassword.equals(adminPassword)) {
                System.out.println("          Admin login successful!!!          ");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
                break; // Exit the admin login loop
            } else {
                System.out.println("          Invalid admin credentials. Please try again.          ");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

            }
            
        }
     // Handle user registration
        UserInputHandler.handleUserRegistration(taskService, sc);




        do {
        	System.out.println("                                                                                                                                      ");
        	System.out.println("                                                Here are the Tasks in Your Queue:                                                       ");
        	System.out.println("                                                                                                                                      ");
            System.out.println("\t\t					1) View all tasks\r\n"
                    + "\t\t					2) Add a new task\r\n"
                    + "\t\t					3) View a task by ID\r\n"
                    + "\t\t					4) View task by Status\r\n"
                    + "\t\t					5) Update a task\r\n"
                    + "\t\t					6) Mark a task as complete\r\n"
                    + "\t\t					7) Delete a task by ID\r\n"
                    + "\t\t					8) Delete all tasks");
                   
            System.out.println("====================================================================================================================================");
            System.out.println("Enter your choice:");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    taskService.viewAllTasks();
                    break;
                case 2:
                    taskService.addTask();
                    break;
                case 3:
                    taskService.viewTaskById();
                    break;
                case 4:
                    taskService.viewTasksByStatus();
                    break;
                case 5:
                    taskService.updateTask();
                    break;
                case 6:
                    taskService.markTaskAsComplete();
                    break;
                case 7:
                    taskService.deleteTask();
                    break;
                case 8:
                    taskService.deleteAllTasks();
                    break;
                
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println("Do you want to continue? (Y-Yes / N-No)");
            choice = sc.next();

        } 
    	while(choice.equals("YES")||choice.equals("Y"));
		System.out.println("=======================================================================================================================================");

		System.out.println("                              Thank you ! We hope to welcome you again soon.........                                                      ");

		System.out.println("=======================================================================================================================================");

    }
}
