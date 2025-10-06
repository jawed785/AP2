package tv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class mainConnector {
	

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			System.out.println(">>> DÉMARRAGE DU PROGRAMME");

			String BDD = "BANQUE";
			String url = "jdbc:mysql://localhost:3306/"+BDD;
			String user = "root";
			String password = "root";
			ResultSet resultat;

			String requete = "SELECT * FROM client";

			Class.forName("com.mysql.cj.jdbc.Driver");
			//com.mysql.jdbc.Driver
			Connection conn = DriverManager.getConnection(url, user, password);
			

			
			Statement stmt1 = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			ResultSet maj = stmt1.executeQuery(requete);
			ResultSet resultat1 = stmt1.executeQuery("SELECT * FROM client");
			int resultat2 = stmt2.executeUpdate("UPDATE CLIENT SET tel = '0612345678' WHERE id= 1");
			while (resultat1.next()) {
				
				System.out.println();
				String nom = resultat1.getString("nom");
				String prenom = resultat1.getString("prenom");
				int genre = resultat1.getInt("genre");
				String date = resultat1.getString("date");
				String adresse = resultat1.getString("adresse");
				String tel = resultat1.getString("tel");
				String email = resultat1.getString("email");

					System.out.println("client : " + nom + ", " + prenom + ", " + genre + ", " + date + ", " + adresse + ", " + tel + ", " + email);
				}
			
			
			//ResultSet resultat2 = stmt.executeUpdate("SELECT * FROM client");
			
			
			//creer l'adherent 1 avant
			//System.out.println(ad1.getListLivre().size(););
			
			
	}}


