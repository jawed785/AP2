package tv;

public class CATEGORIE {


	
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public CATEGORIE(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "CATEGORIE [nom=" + nom + "]";
	}
	

	
	

}
