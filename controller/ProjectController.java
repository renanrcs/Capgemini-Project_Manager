package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import model.Project;
import util.ConnectionFactory;

public class ProjectController {
	
	public void save(Project project) {
		
		String sql = "INSERT into projects (name, description, createdAt, updatedAt)"
				+ "VALUES (?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("Eroo ao salvar Projeto" + e.getMessage() + e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
}
