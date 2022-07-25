package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
import javax.swing.table.TableModel;

import controller.ProjectController;
import controller.TaskController;
import model.Project;
import model.Task;
import util.TaskTableModel;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JTable tableTask;
	private JList<Project> JlistProjects;

	ProjectController projectController;
	TaskController taskController;
	
	DefaultListModel projectsModel;
	//DefaultListModel taskModel;
	TaskTableModel taskModel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		
		setMinimumSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelToolBar = new JPanel();
		panelToolBar.setBackground(new Color(0, 153, 102));
		
		JLabel LabelToolBarTitle = new JLabel(" Gestor de Projetos");
		LabelToolBarTitle.setIcon(new ImageIcon("C:\\Users\\Rcs145\\capgemini-workspace\\Capgemini Project Manager\\src\\projectManager\\resources\\ok-icon.png"));
		LabelToolBarTitle.setForeground(Color.WHITE);
		LabelToolBarTitle.setBackground(new Color(255, 255, 255));
		LabelToolBarTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
		
		JLabel labelToolBarSubtitle = new JLabel("Anote tudo, n\u00E3o esque\u00E7a de nada");
		labelToolBarSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		labelToolBarSubtitle.setForeground(Color.WHITE);
		
		JPanel panelProjects = new JPanel();
		panelProjects.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelProjects.setBackground(Color.WHITE);
		
		JPanel panelTasks = new JPanel();
		panelTasks.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTasks.setBackground(Color.WHITE);
		
		JPanel panelProjectsList = new JPanel();
		panelProjectsList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelProjectsList.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panelToolBar, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelProjectsList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelProjects, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
						.addComponent(panelTasks, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelToolBar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelTasks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelProjects, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelProjectsList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableTask = new JTable();
		tableTask.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tableTask.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Customizando o header da table de tarefas
		tableTask.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tableTask.getTableHeader().setBackground(new Color(0, 153, 152));
		tableTask.getTableHeader().setForeground(new Color(255, 255, 255));
		
		//Criando um sort automatico para as colunas da table
		tableTask.setAutoCreateRowSorter(true);
		
		tableTask.setShowHorizontalLines(false);
		tableTask.setRowHeight(25);
		tableTask.setShowVerticalLines(false);
		tableTask.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nome", "Descricao", "Prazo", "Tarefa Concluida"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableTask);
		panel_4.setLayout(gl_panel_4);
		
		/*JPanel panelEmptyList = new JPanel();
		panelEmptyList.setBackground(Color.WHITE);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelEmptyList, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelEmptyList, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel labelEmptyListIcon = new JLabel("");
		labelEmptyListIcon.setHorizontalAlignment(SwingConstants.CENTER);
		labelEmptyListIcon.setIcon(new ImageIcon("C:\\Users\\Rcs145\\capgemini-workspace\\Capgemini Project Manager\\src\\projectManager\\resources\\list-icon.png"));
		
		JLabel labelEmptyListTitle = new JLabel("Nenhuma tarefa por aqui :|)");
		labelEmptyListTitle.setForeground(new Color(0, 153, 102));
		labelEmptyListTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelEmptyListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel labelEmptyListSubtitle = new JLabel("Clique no bot\u00E3o + para adicionar uma nova tarefa");
		labelEmptyListSubtitle.setForeground(new Color(204, 204, 204));
		labelEmptyListSubtitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
		labelEmptyListSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panelEmptyList = new GroupLayout(panelEmptyList);
		gl_panelEmptyList.setHorizontalGroup(
			gl_panelEmptyList.createParallelGroup(Alignment.LEADING)
				.addComponent(labelEmptyListIcon, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panelEmptyList.createSequentialGroup()
					.addGroup(gl_panelEmptyList.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelEmptyListSubtitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
						.addComponent(labelEmptyListTitle, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelEmptyList.setVerticalGroup(
			gl_panelEmptyList.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelEmptyList.createSequentialGroup()
					.addContainerGap(130, Short.MAX_VALUE)
					.addComponent(labelEmptyListIcon)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelEmptyListTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelEmptyListSubtitle)
					.addGap(100))
		);
		panelEmptyList.setLayout(gl_panelEmptyList);
		panel_4.setLayout(gl_panel_4);*/
		
		JScrollPane scrollPaneProjects = new JScrollPane();
		GroupLayout gl_panelProjectsList = new GroupLayout(panelProjectsList);
		gl_panelProjectsList.setHorizontalGroup(
			gl_panelProjectsList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProjectsList.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneProjects, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelProjectsList.setVerticalGroup(
			gl_panelProjectsList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProjectsList.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneProjects, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JlistProjects = new JList<Project>();
		
		JlistProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneProjects.setViewportView(JlistProjects);
		JlistProjects.setFixedCellHeight(50);
		JlistProjects.setSelectionBackground(new Color(0, 153, 102));
		JlistProjects.setFont(new Font("Segoe UI", Font.BOLD, 18));
		JlistProjects.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelProjectsList.setLayout(gl_panelProjectsList);
		
		JLabel labelTasksTitle = new JLabel("Tarefas");
		labelTasksTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		labelTasksTitle.setForeground(new Color(0, 153, 102));
		
		JLabel labelTasksAdd = new JLabel("");
		labelTasksAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TaskDialogScreen taskDialogScreen = new TaskDialogScreen();
				taskDialogScreen.setVisible(true);
				
				taskDialogScreen.addWindowListener(new WindowAdapter() {
					
					public void windowClosed(WindowEvent e) {
						loadTasks(3);
					}
				});
			}
		});
		
		labelTasksAdd.setIcon(new ImageIcon("C:\\Users\\Rcs145\\capgemini-workspace\\Capgemini Project Manager\\src\\projectManager\\resources\\add-icon.png"));
		GroupLayout gl_panelTasks = new GroupLayout(panelTasks);
		gl_panelTasks.setHorizontalGroup(
			gl_panelTasks.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTasks.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelTasksTitle, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
					.addComponent(labelTasksAdd, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelTasks.setVerticalGroup(
			gl_panelTasks.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTasks.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTasks.createParallelGroup(Alignment.LEADING)
						.addComponent(labelTasksAdd, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelTasksTitle, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelTasks.setLayout(gl_panelTasks);
		
		JLabel labelProjectsTitle = new JLabel("Projetos");
		labelProjectsTitle.setForeground(new Color(0, 153, 102));
		labelProjectsTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		JLabel labelProjectsAdd = new JLabel("");
		labelProjectsAdd.addMouseListener(new MouseAdapter() {
			private ProjectDialogScreen projectDialogScreen;

			@Override
			public void mouseClicked(MouseEvent e) {
				projectDialogScreen = new ProjectDialogScreen();
				projectDialogScreen.setVisible(true);
				
				projectDialogScreen.addWindowListener(new WindowAdapter() {
					
					public void windowClosed(WindowEvent e) {
						loadProjects();
					}
				});
			}
		});
		labelProjectsAdd.setIcon(new ImageIcon("C:\\Users\\Rcs145\\capgemini-workspace\\Capgemini Project Manager\\src\\projectManager\\resources\\add-icon.png"));
		GroupLayout gl_panelProjects = new GroupLayout(panelProjects);
		gl_panelProjects.setHorizontalGroup(
			gl_panelProjects.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProjects.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelProjectsTitle, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(labelProjectsAdd)
					.addContainerGap())
		);
		gl_panelProjects.setVerticalGroup(
			gl_panelProjects.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelProjects.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelProjects.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelProjectsTitle, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
						.addComponent(labelProjectsAdd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelProjects.setLayout(gl_panelProjects);
		GroupLayout gl_panelToolBar = new GroupLayout(panelToolBar);
		gl_panelToolBar.setHorizontalGroup(
			gl_panelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelToolBar.createSequentialGroup()
					.addGap(10)
					.addComponent(LabelToolBarTitle, GroupLayout.PREFERRED_SIZE, 557, Short.MAX_VALUE))
				.addGroup(gl_panelToolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelToolBarSubtitle, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelToolBar.setVerticalGroup(
			gl_panelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelToolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelToolBarTitle, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelToolBarSubtitle, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(256))
		);
		panelToolBar.setLayout(gl_panelToolBar);
		contentPane.setLayout(gl_contentPane);
		
		//metodo para inicializar os controllers
				initDataController();
				initComponentsModel();
	}
	
	public void initDataController() {
		projectController = new ProjectController();
		taskController = new TaskController();
	}
	
	public void initComponentsModel() {
		projectsModel =  new DefaultListModel();
		loadProjects();
		
		taskModel = new TaskTableModel();
		tableTask.setModel(taskModel);
		
		loadTasks(3);
	}
	
	public void loadTasks(int idProject) {
		List<Task> tasks = taskController.getAll(idProject);
		
		taskModel.setTasks(tasks);
	}
	
	public void loadProjects() {
		List<Project> projects = projectController.getAll();
		
		projectsModel.clear();
		
		for(int i = 0; i < projects.size(); i++) {
			
			Project project = projects.get(i);
			projectsModel.addElement(project);
		}

		
		JlistProjects.setModel(projectsModel);
	}
}
