package personnages;

import objet.Equipement;
import village.Village;

public class Gaulois {

	private String nom;
//	private int force;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private Village village = null;
	private int effetPotion;

	private Boolean isInvariantVerified() {
		return force >= 0;
	}

	public Gaulois(String nom, int force) {
		assert isInvariantVerified() : "Pré-Condition a la reception d'un coup";
		this.force = force;
		this.nom = nom;
		this.effetPotion = 1;
		assert isInvariantVerified() : "Invariant a la reception d'un coup";
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void sePresenter() {

		final String bj_je_m_appelle = "Bonjour, je m'appelle ";

		if (this.village == null) {
			System.out.println(bj_je_m_appelle + this.getNom() + ". Je voyage de villages en villages");
		} else if (this.village.getChef() == this) {
			System.out.println(bj_je_m_appelle + this.getNom() + ". Je suis le chef " + this.village.getNom());
		} else {
			System.out.println(bj_je_m_appelle + this.getNom() + ". J'habite le village " + this.village.getNom());
		}
	}

//	public void frapper(Romain romain) {
//		String nomRomain = romain.getNom();
//		System.out.println(nom + "envoie un grand coup dans la mêchoire de " + nomRomain);
//		int forceCoup = (force * effetPotion) / 3;
//		if (effetPotion != 1) {
//			effetPotion--;
//		}
//		romain.recevoirCoup(forceCoup);
//		assert isInvariantVerified() : "Invariant a la reception d'un coup";
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] romainTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; romainTrophees != null && i < romainTrophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = romainTrophees[i];
		}
	}

	public void recevoirCoup(int forceCoup) {
		this.force = this.force - forceCoup;
		if (this.force <= 0) {
			this.prendreParole();
			this.parler("J'abandonne !");
		} else {
			this.prendreParole();
			this.parler("Aïe");
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	@Override
	public String toString() {
		return nom;
	}

}
