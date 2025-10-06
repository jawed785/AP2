package tv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class mainPOO {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CATEGORIE cat1 = new CATEGORIE("cadre");
		CATEGORIE cat2;
		cat2 = new CATEGORIE("ouvrier");

		COMPTE c1 = new COMPTE("C01", 1000, "EURO", null);
		COMPTE c2 = new COMPTE("C02", 2000, "dollar", null);
		//(String nom, String prenom, int genre, String date, CATEGORIE categ, String adresse, String tel,String email, ArrayList<COMPTE> lstcompte
		CLIENT cl1 = new CLIENT("Duck","Donald",1,null,null,null,null,null, new ArrayList<COMPTE>());

		cl1.setCateg(cat2);

		c1.setLetitulaire(cl1);
		c2.setLetitulaire(cl1);


		cl1.getLstcompte().add(c1);
		cl1.getLstcompte().add(c2);

		System.out.println("nombre de compte " + cl1.getLstcompte().size());

		for (int i=0;i!= cl1.getLstcompte().size() ; i++)
		{		
			System.out.println("n ° "+cl1.getLstcompte().get(i).getNumero()+
					" - solde : "+cl1.getLstcompte().get(i).getSolde()+
					" - devise : "+cl1.getLstcompte().get(i).getDevise());
		}
		
		//OU
		
		for (COMPTE c : cl1.getLstcompte())
		{
			System.out.println("n ° "+c.getNumero()+
					" - solde : "+c.getSolde()+
					" - devise : "+c.getDevise());
		}
	}}


