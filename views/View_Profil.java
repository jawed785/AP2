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
import javax.swing.JButton;
import java.awt.Font;

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
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;
	private JLabel lblMessage_Valider;

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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1249, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N° Client :");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(404, 132, 97, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_numClient = new JTextField();
		textField_numClient.setBounds(500, 129, 165, 20);
		frame.getContentPane().add(textField_numClient);
		textField_numClient.setColumns(10);
		
		lblMessage = new JLabel("Veuillez entrer votre numéro de référence");
		lblMessage.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(453, 154, 266, 39);
		frame.getContentPane().add(lblMessage);
		
		panel = new JPanel();
		panel.setBounds(208, 204, 826, 269);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(28, 73, 70, 18);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Prenom :");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_2.setBounds(10, 115, 85, 18);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_3.setBounds(28, 144, 78, 31);
		panel.add(lblNewLabel_3);
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(116, 71, 151, 22);
		panel.add(textField_Nom);
		textField_Nom.setColumns(10);
		
		textField_Prenom = new JTextField();
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(116, 111, 151, 22);
		panel.add(textField_Prenom);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(116, 148, 151, 22);
		panel.add(textField_Email);
		
		List list = new List();
		list.setBounds(315, 10, 501, 249);
		panel.add(list);
		
		lblMessage_Valider = new JLabel("VOS INFOS MIS A JOUR");
		lblMessage_Valider.setForeground(new Color(0, 255, 64));
		lblMessage_Valider.setBounds(116, 31, 151, 14);
		panel.add(lblMessage_Valider);
		lblMessage_Valider.setVisible(false);
		
		Button button_verif = new Button("Valider");
		button_verif.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		button_verif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numadherent = textField_numClient.getText();
				ADHERENT adlaurent = mainMVC.getM().findAdherent(numadherent);
				String nom = textField_Nom.getText();
				String prenom = textField_Prenom.getText();
				String email = textField_Email.getText();
				
				try {
					mainMVC.getM().UpdateInfo(numadherent, nom, prenom, email);
					mainMVC.getM().getAll();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblMessage_Valider.setVisible(true);
			}
		});
		button_verif.setBounds(148, 197, 85, 22);
		panel.add(button_verif);
		
		JButton btnNewButton_1 = new JButton("EFFACER");
		btnNewButton_1.setBounds(28, 197, 95, 22);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_numClient.setEnabled(true);
				textField_Nom.setText(null);
				textField_Prenom.setText(null);
				textField_Email.setText(null);
				list.removeMouseListener(null);
				lblMessage_Valider.setVisible(false);
				lblMessage.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		
		Button button_ok = new Button("OK");
		button_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numadherent2 = textField_numClient.getText();
				ADHERENT adlaurent2 = mainMVC.getM().findAdherent(numadherent2);
				
				if (adlaurent2 != null) {
					textField_Nom.setText(adlaurent2.getNom());
					textField_Prenom.setText(adlaurent2.getPrenom());
					textField_Email.setText(adlaurent2.getEmail());
					panel.setVisible(true);
					lblMessage.setVisible(true);
					lblMessage.setText("Adhérent trouvé");
					lblMessage.setForeground(Color.GREEN);
					
					
					textField_numClient.setEnabled(false);
					
					for (LIVRE l : adlaurent2.getListLivre()) {
						list.add("ISBN : " + l.getISBN()+ " - Titre : " + l.getTitre()+ " - Prix : " +l.getPrix()+ " - Auteur : " +l.getAuteur());
						
					}
					
				}
				else {
					lblMessage.setText("Cet identifiant est introuvable");
					lblMessage.setForeground(Color.RED);
				}
				
			}
		});
		button_ok.setBounds(671, 128, 70, 22);
		frame.getContentPane().add(button_ok);
		
		btnNewButton = new JButton("Retourner à l'accueil");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.dispose();
				try {
					View_Accueil window = new View_Accueil();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnNewButton.setBounds(829, 61, 205, 20);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_4 = new JLabel("Mon Profil");
		lblNewLabel_4.setBackground(new Color(0, 128, 128));
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(469, 61, 235, 32);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
