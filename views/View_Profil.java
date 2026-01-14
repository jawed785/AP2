package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;
import model.AUTEUR;

import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class View_Profil {

	private JFrame frame;
	private JTextField textField_numClient;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Email;
	private JLabel lblMessage;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Profil() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 866, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N° Client :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(243, 87, 97, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_numClient = new JTextField();
		textField_numClient.setBounds(320, 84, 165, 20);
		frame.getContentPane().add(textField_numClient);
		textField_numClient.setColumns(10);
		
		lblMessage = new JLabel("Veillez entrer votre numéro de référence");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(307, 137, 223, 14);
		frame.getContentPane().add(lblMessage);
		
		panel = new JPanel();
		panel.setBounds(162, 205, 491, 187);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(21, 68, 46, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Prenom :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_2.setBounds(21, 93, 46, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_3.setBounds(21, 118, 46, 14);
		panel.add(lblNewLabel_3);
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(77, 65, 151, 20);
		panel.add(textField_Nom);
		textField_Nom.setColumns(10);
		
		textField_Prenom = new JTextField();
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(77, 90, 151, 20);
		panel.add(textField_Prenom);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(77, 115, 151, 20);
		panel.add(textField_Email);
		
		List list = new List();
		list.setBounds(280, 10, 201, 167);
		panel.add(list);
		
		Button button_verif = new Button("VERIF");
		button_verif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String numadherent = textField_numClient.getText();
				ADHERENT adlaurent = mainMVC.getM().findAdherent(numadherent);
				for (LIVRE l : adlaurent.getListLivre()) {
					list.add("ISBN : " + l.getISBN()+ " - " + l.getTitre()+ " - " +l.getPrix()+ " - " +l.getAuteur());
				}
			}
		});
		button_verif.setBounds(109, 155, 70, 22);
		panel.add(button_verif);
		
		Button button_ok = new Button("OK");
		button_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numadherent = textField_numClient.getText();
				ADHERENT adlaurent = mainMVC.getM().findAdherent(numadherent);
				
				if (adlaurent != null) {
					textField_Nom.setText(adlaurent.getNom());
					textField_Prenom.setText(adlaurent.getPrenom());
					textField_Email.setText(adlaurent.getEmail());
					panel.setVisible(true);
					lblMessage.setVisible(true);
					lblMessage.setText("Adhérent trouvé");
					lblMessage.setForeground(Color.GREEN);
					
					
					textField_numClient.setEnabled(false);
					
				}
				else {
					lblMessage.setText("Cet id est introuvable");
					lblMessage.setForeground(Color.RED);
				}
				
			}
		});
		button_ok.setBounds(491, 83, 70, 22);
		frame.getContentPane().add(button_ok);
	}
}
