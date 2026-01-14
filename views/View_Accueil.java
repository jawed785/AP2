package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.mainMVC;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class View_Accueil {

	private JFrame frame;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Accueil() throws SQLException {
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
		JButton btnCatalogueDesLivres = new JButton("CATALOGUE DES LIVRES");
		btnCatalogueDesLivres.setBounds(176, 79, 208, 23);
		btnCatalogueDesLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				try {
					View_Catalogue window2 = new View_Catalogue();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnCatalogueDesLivres);
		
		JButton btnProfil = new JButton("PROFIL");
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				try {
					View_Profil window3 = new View_Profil();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnProfil.setBounds(176, 124, 208, 23);
		frame.getContentPane().add(btnProfil);
		
		JButton btnEmprunt = new JButton("DEPOSER");
		btnEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.setVisible(true);
					try {
						View_Deposer window4 = new View_Deposer();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnEmprunt.setBounds(176, 215, 208, 23);
		frame.getContentPane().add(btnEmprunt);
		
		JButton btnEmprunterUnLivre = new JButton("EMPRUNTER");
		btnEmprunterUnLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				try {
					View_Emprunter window5 = new View_Emprunter();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmprunterUnLivre.setBounds(176, 171, 208, 23);
		frame.getContentPane().add(btnEmprunterUnLivre);
	}
}
