package Admin_Task_Management_System;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TaskService {

	static Scanner sc=new Scanner(System.in);
	//private List<User> UserList = new ArrayList<>();
	// Create an instance of Admin
	Admin admin = new Admin("admin", "admin@123");

	private TaskDao taskDao;

	public TaskService(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

   public void viewAllTasks() throws ClassNotFoundException, SQLException {
		List<Task> taskList = taskDao.findAll();

		if (taskList.isEmpty()) {
			System.out.println("No tasks found.");
		} else {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-5s | %-25s | %-50s | %-15s%n", "ID", "Task Name", "Description", "Status");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

			for (Task task : taskList) {
				System.out.printf("%-5d | %-25s | %-50s | %-15s%n", task.getTaskId(), task.getTaskName(), task.getDescription(), task.getStatus());
			}

			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("                                                                                                                                       ");
		}
	}


	public void addTask() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the task name:");
		String taskName = sc.nextLine();
		System.out.println("Enter the task description:");
		String description = sc.nextLine();
		System.out.println("Enter the task status:");
		String status = sc.nextLine();

		Task task = new Task();
		task.setTaskName(taskName);
		task.setDescription(description);
		task.setStatus(status);

		taskDao.addTask(task);
		System.out.println("TaskName "+taskName+ " added successfully.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                                                                                                                       ");
	}



	public void viewTaskById() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the task ID:");
		int taskId = sc.nextInt();


		Task task = new Task();
		task.setTaskId(taskId);

		taskDao.viewTaskById(task);

		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                                                                                                                       ");

	}


	public void viewTasksByStatus() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the task status to view (In Progress/Completed/Not Started):");
		String status = sc.nextLine();

		List<Task> tasks = taskDao.getTasksByStatus(status);

		if (tasks.isEmpty()) {
			System.out.println("No tasks found with the status: " + status);
		} else {
			System.out.println("Tasks with status " + status + ":");
			for (Task task : tasks) {
				System.out.println(task);
				System.out.println("                                                                                                                                      ");
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                                                                                                                       ");
	}

	public void updateTask() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the task ID to update:");
		int taskId = sc.nextInt();

		Task task = new Task();
		task.setTaskId(taskId);

		// Retrieve existing task details
		taskDao.viewTaskById(task);

		// Update task details
		System.out.println("Enter the new task name:");
		task.setTaskName(sc.nextLine()); // Consume the newline character
		task.setTaskName(sc.nextLine());
		System.out.println("Enter the new task description:");
		task.setDescription(sc.nextLine());
		System.out.println("Enter the new task status:");
		task.setStatus(sc.nextLine());

		taskDao.updateTask(task);
		System.out.println("TaskId "+taskId+ " updated successfully.");

		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                                                                                                                       ");
	}

	public void deleteTask() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the task ID to delete:");
		int taskId = sc.nextInt();

		taskDao.deleteTaskById(taskId);
		System.out.println("TaskId " +taskId+ " deleted successfully.");

		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                                                                                                                       ");
	}

	public void deleteAllTasks() throws ClassNotFoundException, SQLException {
		taskDao.deleteAllTasks();
		System.out.println("All tasks deleted successfully.");

		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                                                                                                                       ");
	}


	public void markTaskAsComplete() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the task ID to mark as complete:");
		int taskId = sc.nextInt();

		Task task = taskDao.getTaskById(taskId);

		if (task != null) {
			task.setStatus("Completed");
			taskDao.updateTask(task);
			System.out.println("TaskId "+taskId+ " marked as complete.");
		} else {
			System.out.println("Task not found.");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                                                                                                                       ");
	}

}

