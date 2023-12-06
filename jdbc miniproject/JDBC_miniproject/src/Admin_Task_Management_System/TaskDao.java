package Admin_Task_Management_System;



import java.sql.SQLException;
import java.util.List;

public interface TaskDao {
    List<Task> findAll() throws ClassNotFoundException, SQLException;

    void addTask(Task task) throws ClassNotFoundException, SQLException;

    void updateTask(Task task) throws ClassNotFoundException, SQLException;

    void viewTaskById(Task task) throws ClassNotFoundException, SQLException;
    
    List<Task> getTasksByStatus(String status) throws ClassNotFoundException, SQLException;

    void deleteTaskById(int taskId) throws ClassNotFoundException, SQLException;

    void deleteAllTasks() throws ClassNotFoundException, SQLException;

    List<Task> getAllTasks();

    Task getTaskById(int taskId) throws ClassNotFoundException, SQLException;
    
    // Additional method to mark a task as complete
    void markTaskAsComplete(int taskId) throws ClassNotFoundException, SQLException;
}

