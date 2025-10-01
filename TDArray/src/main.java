import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		Livre livre1,livre2,livre3,livre4;
		int prix;
		String Titre, Auteur;
		livre1 = new Livre("1","France", "Macron", 1000);
		livre2 = new Livre("2","Algérie", "Tebboun", 2000);
		livre3 = new Livre("3","Maroc", "M6", 3000);
		livre4 = new Livre("4","Tunisie", "Saied", 4000);
		
		
		
		/*livre1.Afficher();
		livre2.Afficher();
		livre3.Afficher();
		System.out.println("");
		livre4.Afficher();*/
		
		ArrayList<Livre>lstlivre;
		lstlivre = new ArrayList<Livre>(); 
		lstlivre.add(livre4);
		lstlivre.get(0);
		
		for(int i=0 ; i != lstlivre.size();i++) {
			lstlivre.get(i).Afficher();
		}
		
	}

}

