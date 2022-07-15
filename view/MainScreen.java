package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainScreen extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 102));
		
		JLabel lblNewLabel = new JLabel("Todo App");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
		
		JLabel lblAnoteTudo = new JLabel("Anote tudo, n\u00E3o esque\u00E7a de nada");
		lblAnoteTudo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblAnoteTudo.setForeground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
						.addComponent(lblAnoteTudo, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblAnoteTudo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
