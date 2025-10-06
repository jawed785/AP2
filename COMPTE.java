package tv;

public class COMPTE {

	private String numero;
	private float solde;
	private String devise;
	private CLIENT letitulaire;
	
	
	@Override
	public String toString() {
		return "COMPTE [numero=" + numero + ", solde=" + solde + ", devise=" + devise + ", letitulaire=" + letitulaire
				+ "]";
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public float getSolde() {
		return solde;
	}


	public void setSolde(float solde) {
		this.solde = solde;
	}


	public String getDevise() {
		return devise;
	}


	public void setDevise(String devise) {
		this.devise = devise;
	}


	public CLIENT getLetitulaire() {
		return letitulaire;
	}


	public void setLetitulaire(CLIENT letitulaire) {
		this.letitulaire = letitulaire;
	}


	public COMPTE(String numero, float solde, String devise, CLIENT letitulaire) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.devise = devise;
		this.letitulaire = letitulaire;
	}
}
