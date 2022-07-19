package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import util.ConnectionFactory;

public class ProjectController {
	
	public void save(Project project) {
		
		String sql = "INSERT INTO projects (name, "
				+ "description, "
				+ "createdAt, "
				+ "updatedAt)"
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
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao salvar Projeto", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
	
	public void update(Project project) {
		
		String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ?"
				+ "WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.setInt(5, project.getId());
			
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualiza o Projeto", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void removeById(int id) {
		
		String sql = "DELETE FROM projects WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar o Projeto", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
	
	public List<Project> getAll(){
		
		String sql = "SELECT * FROM projects";
		
		List<Project> projects = new ArrayList<Project>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;		
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			//statement.setInt(1, id);
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				Project project = new Project();
				
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setCreatedAt(resultSet.getDate("createdAt"));
				project.setUpdatedAt(resultSet.getDate("updatedAt"));
				
				projects.add(project);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar os projetos", e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
			//Lista de tarefas que foi criada e carregada do DB
		return projects;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}