package view;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class View_Deposer {

	private JFrame frame;
	private JTextField textField_ISBN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Deposer window4 = new View_Deposer();
					window4.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Deposer() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(500, 400);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label label = new Label("ISBN :");
		label.setBounds(71, 52, 37, 22);
		frame.getContentPane().add(label);
		
		Label label_Message = new Label("Rentrer un ISBN valide");
		label_Message.setAlignment(Label.CENTER);
		label_Message.setBounds(124, 81, 144, 22);
		frame.getContentPane().add(label_Message);
		
		Button button_OK = new Button("OK");
		button_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numISBN = textField_ISBN.getText();
				LIVRE isbn = mainMVC.getM().findLivre(numISBN);
				
				if (isbn != null) {
					try {
						mainMVC.getM().Deposer(numISBN);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					label_Message.setVisible(true);
					label_Message.setText("Livre déposé avec succès");				
					label_Message.setForeground(Color.GREEN);
					textField_ISBN.setEnabled(false);
					
				}
				else {
					label_Message.setText("Cet ISBN ne correspond à aucun livre");
					label_Message.setForeground(Color.RED);
				}
			}
		});
		button_OK.setBounds(296, 52, 70, 22);
		frame.getContentPane().add(button_OK);
		
		textField_ISBN = new JTextField();
		textField_ISBN.setBounds(114, 52, 154, 20);
		frame.getContentPane().add(textField_ISBN);
		textField_ISBN.setColumns(10);
	}
}
