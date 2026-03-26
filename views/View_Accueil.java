package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.mainMVC;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import javax.swing.ImageIcon;

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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setSize(1249, 599);
		JButton btnCatalogueDesLivres = new JButton("CATALOGUE DES LIVRES");
		btnCatalogueDesLivres.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnCatalogueDesLivres.setBounds(94, 97, 249, 58);
		btnCatalogueDesLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.dispose();
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
		
		JButton btnProfil = new JButton("MON PROFIL");
		btnProfil.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.dispose();
				try {
					View_Profil window3 = new View_Profil();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnProfil.setBounds(867, 97, 231, 58);
		frame.getContentPane().add(btnProfil);
		
		JButton btnEmprunt = new JButton("DEPOSER UN LIVRE");
		btnEmprunt.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.dispose();
				try {
						View_Deposer window4 = new View_Deposer();
				} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
			}
		});
		btnEmprunt.setBounds(107, 338, 231, 58);
		frame.getContentPane().add(btnEmprunt);
		
		JButton btnEmprunterUnLivre = new JButton("EMPRUNTER UN LIVRE");
		btnEmprunterUnLivre.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnEmprunterUnLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.dispose();
				try {
					View_Emprunter window5 = new View_Emprunter();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmprunterUnLivre.setBounds(867, 338, 231, 58);
		frame.getContentPane().add(btnEmprunterUnLivre);
		
		JLabel lblNewLabel = new JLabel("Bibliothèque");
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(422, 47, 354, 58);
		frame.getContentPane().add(lblNewLabel);
		
		/*111111111111111111111111111111111*/
		ImageIcon icon1 = new ImageIcon("C:\\Users\\GB\\Downloads\\catalogue.jpg");
		Image img1 = icon1.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);

		JLabel lblNewLabel_img1 = new JLabel("");
		lblNewLabel_img1.setIcon(new ImageIcon(img1));

		lblNewLabel_img1.setBounds(128, 177, 200, 150);
		frame.getContentPane().add(lblNewLabel_img1);
		
		/*2222222222222222222222222222222222*/
		ImageIcon icon2 = new ImageIcon("C:\\Users\\GB\\Downloads\\profil.png");
		Image img2 = icon2.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);

		JLabel lblNewLabel_img2 = new JLabel("");
		lblNewLabel_img2.setIcon(new ImageIcon(img2));

		lblNewLabel_img2.setBounds(877, 166, 200, 150);
		frame.getContentPane().add(lblNewLabel_img2);
		
		/*333333333333333333333333*/
		ImageIcon icon3 = new ImageIcon("C:\\Users\\GB\\Downloads\\deposer.jpg");
		Image img3 = icon3.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);

		JLabel lblNewLabel_img3 = new JLabel("");
		lblNewLabel_img3.setIcon(new ImageIcon(img3));

		lblNewLabel_img3.setBounds(128, 407, 200, 150);
		frame.getContentPane().add(lblNewLabel_img3);
		
		/*444444444444444444444444444444444444*/
		ImageIcon icon4 = new ImageIcon("C:\\Users\\GB\\Downloads\\emprunt.jpg");
		Image img4 = icon4.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);

		JLabel lblNewLabel_img4 = new JLabel("");
		lblNewLabel_img4.setIcon(new ImageIcon(img4));

		lblNewLabel_img4.setBounds(887, 407, 200, 150);
		frame.getContentPane().add(lblNewLabel_img4);	

	}
}
