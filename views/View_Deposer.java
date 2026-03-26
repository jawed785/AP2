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
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class View_Deposer {

	private JFrame frame;
	private JTextField textField_ISBN;

	/**
	 * Launch the application.
	 */

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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("Segoe Print", Font.PLAIN, 11));
		frame.setSize(1249, 599);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label label = new Label("ISBN :");
		label.setBounds(34, 85, 70, 51);
		label.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		frame.getContentPane().add(label);
		
		Label label_Message = new Label("Rentrer un ISBN valide");
		label_Message.setBounds(119, 77, 144, 22);
		label_Message.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		label_Message.setAlignment(Label.CENTER);
		frame.getContentPane().add(label_Message);
		
		Button button_OK = new Button("OK");
		button_OK.setBounds(294, 105, 70, 22);
		button_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numISBN = textField_ISBN.getText();
				LIVRE isbn = mainMVC.getM().findLivre(numISBN);
				
				if (isbn != null) {
					try {
						mainMVC.getM().Deposer(numISBN);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
		frame.getContentPane().add(button_OK);
		
		textField_ISBN = new JTextField();
		textField_ISBN.setBounds(119, 105, 154, 20);
		frame.getContentPane().add(textField_ISBN);
		textField_ISBN.setColumns(10);
		
		JButton btnNewButton = new JButton("Retourner à l'accueil");
		btnNewButton.setBounds(215, 11, 209, 22);
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.dispose();
				try {
					View_Accueil window = new View_Accueil();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(0, 128, 128));
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Déposer un livre");
		lblNewLabel.setBounds(83, 44, 247, 35);
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel);
	}
}
