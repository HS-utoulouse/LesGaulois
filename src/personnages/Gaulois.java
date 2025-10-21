package personnages;

import village.Village;

public class Gaulois {

	private String nom;
	private int force;
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
		return "Le Gaulois " + this.nom + " : ";
	}

	public void sePresenter() {
		if (this.village == null) {
			System.out.println("Bonjour, je m'appelle " + this.getNom() + ". Je voyage de villages en villages");
		} else if (this.village.getChef() == this) {
			System.out.println("Bonjour, je m'appelle " + this.getNom() + ". Je suis le chef " + this.village.getNom());
		} else {
			System.out.println(
					"Bonjour, je m'appelle " + this.getNom() + ". J'habite le village " + this.village.getNom());
		}
	}

	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + "envoie un grand coup dans la mêchoire de " + nomRomain);
		int forceCoup = (force * effetPotion) / 3;
		if (effetPotion != 1) {
			effetPotion--;
		}
		romain.recevoirCoup(forceCoup);
		assert isInvariantVerified() : "Invariant a la reception d'un coup";
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
