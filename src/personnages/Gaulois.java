package personnages;

import objet.Equipement;
import village.Village;
import village.Musee;

public class Gaulois {

	private String nom;
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

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			System.out.println("Le gaulois " + getNom() + " : Je donne au musee tous mes trophées :");
			for (int i = 0; i < nbTrophees; i++) {
				System.out.println("- " + trophees[i].getNom());
				musee.donnerTrophees(this, trophees[i]);
			}
			nbTrophees = 0;
		} else {
			System.out.println("Le gaulois " + getNom() + " n'a aucun trophée à donner.");
		}
	}

	@Override
	public String toString() {
		return nom;
	}

	public static void main(String[] args) {
		int forceAsterix = 8;
		int forceObelix = 16;
		int forceMinus = 6;
		int forceBrutus = 14;
		int forcePanoramix = 2;

		Gaulois Asterix = new Gaulois("Asterix", forceAsterix);

		Gaulois Obelix = new Gaulois("Obélix", forceObelix);

		Asterix.parler("Bonjour Obélix.");
		Obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?)");
		Asterix.parler("Oui très bonne idée.");

		System.out.println("=================================================");

		Romain Minus = new Romain("Minus", forceMinus);

		System.out.println("Dans la forêt " + Asterix + " et " + Obelix + " tombent nez à nez sur le romain Minus");

		for (int i = 0; i < 3; i++) {
			Asterix.frapper(Minus);
		}

		System.out.println("=================================================");

		Romain Brutus = new Romain("Brutus", forceBrutus);

		Druide Panoramix = new Druide("Panoramix", forcePanoramix);

		Panoramix.fabriquerPotion(4, 3);

		Panoramix.booster(Obelix);
		Panoramix.booster(Asterix);

		System.out.println("=================================================");

		for (int i = 0; i < 3; i++) {
			Asterix.frapper(Brutus);
		}
		System.out.println("=================================================\n");

		Asterix.trophees[0] = Equipement.BOUCLIER;
		Asterix.trophees[1] = Equipement.CASQUE;
		Asterix.trophees[2] = Equipement.CASQUE;
		Asterix.nbTrophees = 3;

		Musee Athène = new Musee();

		Asterix.faireUneDonnation(Athène);

		System.out.println("\n");

		System.out.print(Athène.extraireInstructionsOCaml());
	}
}
