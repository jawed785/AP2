package view;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;

import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class View_Emprunter {

	private JFrame frame;
	private JTextField textField_ISBN;
	private JTextField textField_numClient;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Emprunter() throws SQLException {
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
		frame.setBounds(100, 100, 1252, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label label_1 = new Label("ISBN :");
		label_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(356, 210, 80, 45);
		frame.getContentPane().add(label_1);
		
		Label label_1_1 = new Label("N° Client :");
		label_1_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		label_1_1.setAlignment(Label.CENTER);
		label_1_1.setBounds(356, 261, 80, 45);
		frame.getContentPane().add(label_1_1);
		
		textField_ISBN = new JTextField();
		textField_ISBN.setColumns(10);
		textField_ISBN.setBounds(442, 224, 204, 31);
		frame.getContentPane().add(textField_ISBN);
		
		textField_numClient = new JTextField();
		textField_numClient.setColumns(10);
		textField_numClient.setBounds(442, 275, 204, 31);
		frame.getContentPane().add(textField_numClient);
		
		Label label_Message = new Label("");
		label_Message.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		label_Message.setAlignment(Label.CENTER);
		label_Message.setVisible(false);
		label_Message.setBounds(250, 334, 630, 143);
		frame.getContentPane().add(label_Message);
		
		Button button_ok = new Button("OK");
		button_ok.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		button_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = textField_ISBN.getText();
				LIVRE ISBN = mainMVC.getM().findLivre(isbn);
				String numClient = textField_numClient.getText();
				ADHERENT adlaurent = mainMVC.getM().findAdherent(numClient);
				if (ISBN != null && adlaurent != null) {
					try {
						mainMVC.getM().Emprunter(isbn,numClient);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					label_Message.setVisible(true);
					label_Message.setText("Livre emprunté avec succès");
					label_Message.setForeground(Color.GREEN);
				}
				else {
					label_Message.setVisible(true);
					label_Message.setText("ISBN ou N°Client introuvable");
					label_Message.setForeground(Color.RED);
				}
				
				
			}
		});
		button_ok.setBounds(703, 224, 91, 46);
		frame.getContentPane().add(button_ok);
		
		JButton btnNewButton = new JButton("Retourner à l'accueil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.dispose();
				try {
					View_Accueil window = new View_Accueil();
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(942, 41, 232, 31);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("EMPRUNTER UN LIVRE");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblNewLabel.setBounds(318, 69, 446, 43);
		frame.getContentPane().add(lblNewLabel);
	}
}
