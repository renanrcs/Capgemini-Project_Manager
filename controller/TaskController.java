package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Task;
import util.ConnectionFactory;

public class TaskController {
	
	public void save(Task task) {
		
		String sql = "INSERT INTO tasks (idProject, name, description, "
				+ "status, notes, deadline, createdAt, updatedAt) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("Eroo ao salvar tarefa" + e.getMessage() + e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
		
	}
	
	public void update(Task task) {
		
		String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?, notes = ?"
				+ "status = ?, deadline = ?, createdAt = ?, updatedAt = ?"
				+ "WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setString(4, task.getNotes());
			statement.setBoolean(5, task.isCompleted());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("Eroo ao salvar tarefa" + e.getMessage() + e);
		}
		
	}
	
	public void removeById(int taskId) throws SQLException {
		
		String sql = "DELETE FROM tasks WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, taskId);
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar a tarefa");
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
		
	}
	
	public List<Task> getAll(int idProject) {
		return null;
	}
}
