import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accueil {

	private JFrame frame;
	private ArrayList<Livre>listlivre = new ArrayList<Livre>();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Accueil() {

		Livre livre1 = new Livre("1","France", "Macron", 1000);
		Livre livre2 = new Livre("2","Algérie", "Tebboun", 2000);
		Livre livre3 = new Livre("3","Maroc", "M6", 3000);
		Livre livre4 = new Livre("4","Tunisie", "Saied", 4000);
		Livre livre5 = new Livre("5","Egypte", "Saied", 5000);
		listlivre.add(livre1);
		listlivre.add(livre2);
		listlivre.add(livre3);
		listlivre.add(livre4);
		listlivre.add(livre5);
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(30, 36, 69, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("TITRE DU LIVRE");
		lblNewLabel_2.setBounds(30, 71, 85, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("PRIX DU LIVRE");
		lblNewLabel_3.setBounds(30, 118, 85, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Nombre de livre : ");
		lblNewLabel_4.setBounds(69, 204, 143, 14);
		frame.getContentPane().add(lblNewLabel_4);


		JLabel lblNewLabel_5 = new JLabel("0");
		lblNewLabel_5.setBounds(229, 204, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);

		lblNewLabel_5.setText(String.valueOf(listlivre.size()));



		textField_1 = new JTextField();
		textField_1.setBounds(109, 33, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(109, 68, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(109, 115, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);



		JButton btnNewButton_1 = new JButton("RECHERCHER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ISBN;
				ISBN = textField_1.getText();
				int Prix = Integer.parseInt(textField_3.getText());
				boolean trouver=false;
				
				
				for (int i = 0; i != listlivre.size();i++) {
					
					if (ISBN.equals(listlivre.get(i).getISBN())) {
						
						textField_2.setText(listlivre.get(i).getTitre());
						
						textField_2.setText(listlivre.get(i).getPrix()+"");
						
						trouver=true;
					}
					
				}
				
				if (trouver == true) {
					
					textField_2.setText("erreur");
				}
						
				lblNewLabel_5.setText(String.valueOf(listlivre.size()));

			}
		});
				btnNewButton_1.setBounds(201, 67, 114, 23);
				frame.getContentPane().add(btnNewButton_1);

				JButton btnNewButton_2 = new JButton("AJOUTER");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						/*Livre livre6;
						livre6 = new Livre((textField_1.getText(), textField_2.getText(), textField_3.getText())));

						lstlivre.add(livre6);

						lblNewLabel_5.setText(String.valueOf(listlivre.size()));
						*/
					}
				});
				btnNewButton_2.setBounds(85, 159, 89, 23);
				frame.getContentPane().add(btnNewButton_2);


	}
}