package projectManager;

import java.util.Date;

import controller.ProjectController;
import model.Project;

public class Main {

	public static void main(String[] args) {
		
		ProjectController projectController = new ProjectController();
		
		Project project = new Project();
		
		project.setUpdatedAt(new Date());
		project.setName("Projeto teste");
		
		project.setDescription("Testando se o codigo esta funcionando");
		
		projectController.save(project);
		
	}

}
