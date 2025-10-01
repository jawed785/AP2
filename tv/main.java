package tv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(">>> DÉMARRAGE DU PROGRAMME");

		String BDD = "AP2";
		String url = "jdbc:mysql://localhost:3306/"+BDD;
		String user = "root";
		String password = "root";
		ResultSet resultat;

		String requete = "SELECT * FROM livre";

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		

		
		Statement stmt = conn.createStatement();
		int maj = stmt.executeUpdate(requete);
		ResultSet resultat1 = stmt.executeQuery("SELECT * FROM livre");
		while (resultat1.next()) {
			System.out.println();
			String ISBN = resultat1.getString("ISBN");
			String titre = resultat1.getString("titre");
			int prix = resultat1.getInt("prix");

				System.out.println("livre : " + ISBN + ", " + titre + ", " + prix);
			}
		
		stmt.executeUpdate("INSERT INTO LIVRE VALUES('1','newtitre',10,null,null)");
		//creer l'adherent 1 avant
		System.out.println(ad1.getListLivre().size(););
		
		
}}