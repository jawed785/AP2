package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import controller.mainMVC;
import model.LIVRE;
import java.awt.List;
import java.sql.SQLException;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		List list = new List();
		list.setBounds(45, 25, 341, 204);
		frame.getContentPane().add(list);
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
