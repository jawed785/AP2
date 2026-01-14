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

public class View_Emprunter {

	private JFrame frame;
	private JTextField textField_ISBN;
	private JTextField textField_numClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Emprunter window5 = new View_Emprunter();
					window5.frame.setVisible(true);
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
		frame.setBounds(100, 100, 642, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label label = new Label("EMPRUNTER UN LIVRE");
		label.setBackground(new Color(0, 128, 128));
		label.setAlignment(Label.CENTER);
		label.setBounds(144, 35, 302, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("ISBN :");
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(52, 89, 62, 22);
		frame.getContentPane().add(label_1);
		
		Label label_1_1 = new Label("N° Client :");
		label_1_1.setAlignment(Label.CENTER);
		label_1_1.setBounds(52, 129, 62, 22);
		frame.getContentPane().add(label_1_1);
		
		textField_ISBN = new JTextField();
		textField_ISBN.setColumns(10);
		textField_ISBN.setBounds(120, 91, 165, 20);
		frame.getContentPane().add(textField_ISBN);
		
		textField_numClient = new JTextField();
		textField_numClient.setColumns(10);
		textField_numClient.setBounds(120, 129, 165, 20);
		frame.getContentPane().add(textField_numClient);
		
		Label label_Message = new Label("");
		label_Message.setVisible(false);
		label_Message.setBounds(160, 173, 62, 22);
		frame.getContentPane().add(label_Message);
		
		Button button_ok = new Button("OK");
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
		button_ok.setBounds(330, 105, 70, 22);
		frame.getContentPane().add(button_ok);
	}
}
