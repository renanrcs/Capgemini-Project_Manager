package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

import controller.TaskController;
import model.Project;
import model.Task;

import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TaskDialogScreen extends JDialog {
	private JTextField labelTextField;
	TaskController controller = new TaskController();
	Project project = new Project();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskDialogScreen dialog = new TaskDialogScreen();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public TaskDialogScreen() {
		setBounds(100, 100, 490, 517);
		
		JPanel panelToolBar = new JPanel();
		panelToolBar.setBackground(new Color(0, 153, 102));
		
		JPanel panelTask = new JPanel();
		panelTask.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTask, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelToolBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelToolBar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTask, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
		);
		
		JLabel labelName = new JLabel("Nome");
		labelName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		labelTextField = new JTextField();
		labelTextField.setColumns(10);
		
		JLabel labelDescription = new JLabel("Descri\u00E7ao");
		labelDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel labelDeadline = new JLabel("Prazo");
		labelDeadline.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel labelNotes = new JLabel("Notas");
		labelNotes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JFormattedTextField formattedTextFieldDeadline = new JFormattedTextField();
		
		JScrollPane scrollPaneDescription = new JScrollPane();
		
		JScrollPane scrollPaneNotes = new JScrollPane();
		GroupLayout gl_panelTask = new GroupLayout(panelTask);
		gl_panelTask.setHorizontalGroup(
			gl_panelTask.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTask.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTask.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTask.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(labelDescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(labelTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
						.addComponent(scrollPaneDescription, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
						.addComponent(formattedTextFieldDeadline, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
						.addComponent(labelDeadline, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
						.addComponent(scrollPaneNotes, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
						.addComponent(labelNotes, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
						.addComponent(labelName, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelTask.setVerticalGroup(
			gl_panelTask.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelTask.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(labelName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(labelDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneDescription, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(labelDeadline)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(formattedTextFieldDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelNotes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneNotes, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(134))
		);
		
		JTextArea textAreaNotes = new JTextArea();
		scrollPaneNotes.setViewportView(textAreaNotes);
		
		JTextArea textAreaDescription = new JTextArea();
		scrollPaneDescription.setViewportView(textAreaDescription);
		panelTask.setLayout(gl_panelTask);
		
		JLabel labelToolbarTitle = new JLabel("Tarefa");
		labelToolbarTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
		labelToolbarTitle.setForeground(Color.WHITE);
		
		JLabel labelToolBarSave = new JLabel("");
		labelToolBarSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Task task = new Task();
					
					task.setIdProject(project.getId());
					task.setName(labelName.getText());
					task.setDescription(textAreaDescription.getText());
					task.setNotes(textAreaNotes.getText());
					task.setCompleted(false);
					
					SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
					Date deadline = null;
					
					deadline = simpleDate.parse(formattedTextFieldDeadline.getText());
					task.setDeadline(deadline);
					
					controller.save(task);
					JOptionPane.showMessageDialog(labelToolBarSave, "Tarefa salva com Suceso");
					
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(labelToolBarSave, e2.getMessage());
				}
			}
		});
		this.dispose();
		
		labelToolBarSave.setIcon(new ImageIcon("C:\\Users\\Rcs145\\capgemini-workspace\\Capgemini Project Manager\\src\\projectManager\\resources\\ok-icon.png"));
		GroupLayout gl_panelToolBar = new GroupLayout(panelToolBar);
		gl_panelToolBar.setHorizontalGroup(
			gl_panelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelToolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelToolbarTitle)
					.addPreferredGap(ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
					.addComponent(labelToolBarSave, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelToolBar.setVerticalGroup(
			gl_panelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelToolBar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelToolBar.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelToolbarTitle, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
						.addComponent(labelToolBarSave, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelToolBar.setLayout(gl_panelToolBar);
		getContentPane().setLayout(groupLayout);

	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
