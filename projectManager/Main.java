package projectManager;

import java.sql.Connection;

import util.ConnectionFactory;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Project On Fire");
		
		Connection c = (Connection) new ConnectionFactory();
		
		ConnectionFactory.closeConnection(c);
		
		

	}

}
