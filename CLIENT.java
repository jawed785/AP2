package tv;
import java.util.ArrayList;
public class CLIENT {
		
		private String nom;
		private String prenom;
		private int genre;
		private String date;
		private CATEGORIE categ;
		private String adresse;
		private String tel;
		private String email;
		public ArrayList <COMPTE> lstcompte;
		
		public CLIENT(String nom, String prenom, int genre, String date, CATEGORIE categ, String adresse, String tel,
				String email, ArrayList<COMPTE> lstcompte) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.genre = genre;
			this.date = date;
			this.categ = categ;
			this.adresse = adresse;
			this.tel = tel;
			this.email = email;
			this.lstcompte = lstcompte;
		}

		@Override
		public String toString() {
			return "CLIENT [nom=" + nom + ", prenom=" + prenom + ", genre=" + genre + ", date=" + date + ", categ="
					+ categ + ", adresse=" + adresse + ", tel=" + tel + ", email=" + email + ", lstcompte=" + lstcompte
					+ "]";
		}

		public CLIENT(String string, String string2, int i, Object object, CATEGORIE cat2, Object object2,
				Object object3, Object object4, COMPTE compte1, COMPTE compte2) {
			// TODO Auto-generated constructor stub
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public int getGenre() {
			return genre;
		}

		public void setGenre(int genre) {
			this.genre = genre;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public CATEGORIE getCateg() {
			return categ;
		}

		public void setCateg(CATEGORIE categ) {
			this.categ = categ;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public ArrayList<COMPTE> getLstcompte() {
			return lstcompte;
		}

		public void setLstcompte(ArrayList<COMPTE> lstcompte) {
			this.lstcompte = lstcompte;
		}
		
		
		

	}


