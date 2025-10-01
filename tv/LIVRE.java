package tv;

public class LIVRE {
	private String ISBN;
	private String titre;
	private int prix;
	private ADHERENT Emprunteur;
	
	public LIVRE(String iSBN, String titre, int prix, ADHERENT emprunteur, AUTEUR auteur) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		this.prix = prix;
		Emprunteur = emprunteur;
		Auteur = auteur;
	}

	public ADHERENT getEmprunteur() {
		return Emprunteur;
	}

	public void setEmprunteur(ADHERENT emprunteur) {
		Emprunteur = emprunteur;
	}

	public AUTEUR getAuteur() {
		return Auteur;
	}

	public void setAuteur(AUTEUR auteur) {
		Auteur = auteur;
	}

	private AUTEUR Auteur;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	

}
