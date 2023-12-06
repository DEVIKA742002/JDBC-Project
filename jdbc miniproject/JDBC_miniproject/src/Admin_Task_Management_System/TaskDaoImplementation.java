package Admin_Task_Management_System;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImplementation implements TaskDao {
    private static final String URL = "jdbc:mysql://localhost:3306/task_management_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_TASK_SQL = "INSERT INTO tasks (task_name, task_description, status) VALUES (?, ?, ?)";
    private static final String SELECT_TASKS_SQL = "SELECT * FROM tasks";
    private static final String SELECT_TASK_BY_ID_SQL = "SELECT * FROM tasks WHERE task_id = ?";
    private static final String UPDATE_TASK_SQL = "UPDATE tasks SET task_name = ?, task_description = ?, status = ? WHERE task_id = ?";
    private static final String DELETE_TASK_SQL = "DELETE FROM tasks WHERE task_id = ?";
    private static final String MARK_TASK_AS_COMPLETE_SQL = "UPDATE tasks SET status = 'Completed' WHERE task_id = ?";

    @Override
    public List<Task> findAll() throws ClassNotFoundException, SQLException {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASKS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Task task = mapResultSetToTask(resultSet);
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public void addTask(Task task) throws ClassNotFoundException, SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK_SQL)) {
            setTaskParameters(preparedStatement, task);
            preparedStatement.executeUpdate();
        }
    }

    
    
    @Override
    public void viewTaskById(Task task) throws ClassNotFoundException, SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK_BY_ID_SQL)) {
            preparedStatement.setInt(1, task.getTaskId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Populate the task object with details from the result set
                    task.setTaskName(resultSet.getString("task_name"));
                    task.setDescription(resultSet.getString("task_description"));
                    task.setStatus(resultSet.getString("status"));

                    // Display task details
                    System.out.println("Task Details:");
                    System.out.println(task);
                } else {
                    System.out.println("Task not found.");
                }
            }
        }
    }
    
    @Override
    public List<Task> getTasksByStatus(String status) throws ClassNotFoundException, SQLException {
        List<Task> tasks = new ArrayList<>();
        String selectTasksByStatusSQL = "SELECT * FROM tasks WHERE status = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(selectTasksByStatusSQL)) {
            preparedStatement.setString(1, status);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Task task = new Task();
                    task.setTaskId(resultSet.getInt("task_id"));
                    task.setTaskName(resultSet.getString("task_name"));
                    task.setDescription(resultSet.getString("task_description"));
                    task.setStatus(resultSet.getString("status"));
                    tasks.add(task);
                }
            }
        }

        return tasks;
    }



    @Override
    public void updateTask(Task task) throws ClassNotFoundException, SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TASK_SQL)) {
            setTaskParameters(preparedStatement, task);
            preparedStatement.setInt(4, task.getTaskId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteTaskById(int taskId) throws ClassNotFoundException, SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TASK_SQL)) {
            preparedStatement.setInt(1, taskId);
            preparedStatement.executeUpdate();
        }
    }
    
    @Override
    public void deleteAllTasks() throws ClassNotFoundException, SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tasks")) {
            preparedStatement.executeUpdate();
        }
    }


 

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASKS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Task task = mapResultSetToTask(resultSet);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public Task getTaskById(int taskId) throws ClassNotFoundException, SQLException {
        Task task = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK_BY_ID_SQL)) {
            preparedStatement.setInt(1, taskId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    task = mapResultSetToTask(resultSet);
                }
            }
        }
        return task;
    }

    @Override
    public void markTaskAsComplete(int taskId) throws ClassNotFoundException, SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(MARK_TASK_AS_COMPLETE_SQL)) {
            preparedStatement.setInt(1, taskId);
            preparedStatement.executeUpdate();
        }
    }

    private Task mapResultSetToTask(ResultSet resultSet) throws SQLException {
        Task task = new Task();
        task.setTaskId(resultSet.getInt("task_id"));
        task.setTaskName(resultSet.getString("task_name"));
        task.setDescription(resultSet.getString("task_description"));
        task.setStatus(resultSet.getString("status"));
        return task;
    }

    private void mapResultSetToTask(ResultSet resultSet, Task task) throws SQLException {
        task.setTaskName(resultSet.getString("task_name"));
        task.setDescription(resultSet.getString("task_description"));
        task.setStatus(resultSet.getString("status"));
    }

    private void setTaskParameters(PreparedStatement preparedStatement, Task task) throws SQLException {
        preparedStatement.setString(1, task.getTaskName());
        preparedStatement.setString(2, task.getDescription());
        preparedStatement.setString(3, task.getStatus());
    }

	
}
