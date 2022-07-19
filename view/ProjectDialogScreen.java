package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ProjectController;
import model.Project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProjectDialogScreen extends JDialog {

	private final JPanel panelToolBar = new JPanel();
	private JTextField textFieldName;
	
	ProjectController controler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProjectDialogScreen dialog = new ProjectDialogScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProjectDialogScreen() {
		
		controler = new ProjectController();
		
		setBounds(100, 100, 450, 341);
		panelToolBar.setBackground(new Color(0, 153, 102));
		panelToolBar.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panelProject = new JPanel();
		panelProject.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelToolBar, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(panelProject, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelToolBar, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelProject, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
		);
		
		JLabel labelName = new JLabel("Nome");
		labelName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel labelDescription = new JLabel("Descri\u00E7\u00E3o");
		labelDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldName.setColumns(10);
		GroupLayout gl_panelProject = new GroupLayout(panelProject);
		gl_panelProject.setHorizontalGroup(
			gl_panelProject.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProject.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panelProject.createParallelGroup(Alignment.LEADING)
						.addComponent(labelDescription, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
						.addComponent(labelName, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
						.addComponent(textAreaDescription, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
						.addComponent(textFieldName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelProject.setVerticalGroup(
			gl_panelProject.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProject.createSequentialGroup()
					.addGap(21)
					.addComponent(labelName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(labelDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaDescription, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelProject.setLayout(gl_panelProject);
		
		JLabel labelToolBarTitle = new JLabel("Projeto");
		labelToolBarTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		labelToolBarTitle.setForeground(Color.WHITE);
		
		JLabel labelToolBarSave = new JLabel("");
		labelToolBarSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Project project = new Project();
					project.setName(textFieldName.getText());
					project.setDescription(getName());				
					
					controler.save(project);			
					JOptionPane.showMessageDialog(rootPane, "Projeto salvo com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2.getMessage());
				}
				
				this.mouseExited(e);
			}
		});
		labelToolBarSave.setIcon(new ImageIcon("C:\\Users\\Rcs145\\capgemini-workspace\\Capgemini Project Manager\\src\\projectManager\\resources\\ok-icon.png"));
		GroupLayout gl_panelToolBar = new GroupLayout(panelToolBar);
		gl_panelToolBar.setHorizontalGroup(
			gl_panelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelToolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelToolBarTitle)
					.addPreferredGap(ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
					.addComponent(labelToolBarSave)
					.addContainerGap())
		);
		gl_panelToolBar.setVerticalGroup(
			gl_panelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelToolBar.createSequentialGroup()
					.addGroup(gl_panelToolBar.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(labelToolBarTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelToolBarSave, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panelToolBar.setLayout(gl_panelToolBar);
		getContentPane().setLayout(groupLayout);
	}
}
