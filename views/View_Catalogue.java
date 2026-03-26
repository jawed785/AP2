package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import controller.mainMVC;
import model.LIVRE;
import java.awt.List;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Catalogue {

	private JFrame frame;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Catalogue() throws SQLException {
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
		frame.setBounds(100, 100, 1251, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		List list = new List();
		list.setBounds(239, 109, 767, 357);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("Catalogue des livres");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(459, 45, 323, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retourner à l'accueil");
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
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
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(989, 29, 194, 27);
		frame.getContentPane().add(btnNewButton);
		if (mainMVC.getM() != null && mainMVC.getM().getListLivre() != null) {
			for(LIVRE l : mainMVC.getM().getListLivre()) {
				String dispo;
				if(l.getEmprunteur() == null)
				{
					dispo="disponible";
				}
				else {dispo="non disonible";}
				String auteur;
				if(l.getAuteur() == null) {
					auteur="inconnu";
				}
				else {auteur=l.getAuteur().getNom();}

				list.add("ISBN : "+l.getISBN()+" titre : "+l.getTitre()+" de :"+auteur+"("+dispo+")");

			}
		} else {
			list.add("Aucun livre chargé");
		}
	}
}
