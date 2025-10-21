package personnages;

import objets.Equipement;

public class Romain {

	private String nom;
	private int force;
	private int nbEquipements;
	private Equipement[] equipements;

	private Boolean isInvariantVerified() {
		return force >= 0;
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.nbEquipements = 0;
		this.equipements = new Equipement[2];
		assert isInvariantVerified() : "Invariant a la creation";
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	public void frapper(Gaulois gaulois) {
		String nomGaulois = gaulois.getNom();
		System.out.println(nom + "envoie un grand coup dans la mêchoire de " + nomGaulois);
		int forceCoup = force / 3;
		gaulois.recevoirCoup(forceCoup);
	}

	public void recevoirCoup(int forceCoup) {
		assert isInvariantVerified() : "Pré-Condition a la reception d'un coup";
		this.force = this.force - forceCoup;
		if (this.force <= 0) {
			this.prendreParole();
			this.parler("J'abandonne !");
		} else {
			this.prendreParole();
			this.parler("Aïe");
		}
		assert isInvariantVerified() : "Invariant a la reception d'un coup";
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
		case 0: {
			System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement.getNom() + ".");
			equipements[0] = equipement;
			nbEquipements += 1;
			break;
		}
		case 1: {
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + getNom() + " possède déja un " + equipement.getNom() + " !");
			} else {
				System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement.getNom() + ".");
				equipements[1] = equipement;
				nbEquipements += 1;
			}
			break;
		}
		case 2: {
			System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + equipement);
		}
	}

	@Override
	public String toString() {
		return this.nom;
	}

	public static void main(String[] args) {

		Romain Minus = new Romain("Minus", 6);
		Minus.parler("Bonjour !!!!");

		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;

		System.out.println("Équipement 1 : " + casque);
		System.out.println("Équipement 2 : " + bouclier);

		System.out.println();

		Minus.sEquiper(casque);
		Minus.sEquiper(casque);
		Minus.sEquiper(bouclier);
		Minus.sEquiper(casque);
	}

}
