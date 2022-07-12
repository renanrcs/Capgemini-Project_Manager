package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionFactory {
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/databaseprojectgeneral";
	public static final String USER = "root";
	public static final String PASS = "";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception ex) {
			throw new RuntimeException("Erro na conex�a� com o Banco de Dados", ex);
		}
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao fechar conex�a� com o Banco de Dados", ex);
		}
	}
	
	public static void closeConnection(Connection connection, PreparedStatement statement) {
		try {
			if(connection != null) {
				connection.close();
			}
			
			if(statement != null) {
				statement.close();
			}
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao fechar conex�a� com o Banco de Dados", ex);
		}
	}
}
