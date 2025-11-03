package personnages;

import objet.Equipement;

public class Romain {

	private String nom;
	private int force;
	private int nbEquipement;
	private Equipement[] equipements;

	private Boolean isInvariantVerified() {
		return force >= 0;
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.nbEquipement = 0;
		this.equipements = new Equipement[2];
		assert isInvariantVerified() : "Invariant a la creation";
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
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

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;

		if (forceCoup == 0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte = texte + "\nMais heureusement, grace à mon équipement sa force est diminué de "
					+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		final String leSoldat = "Le soldat ";
		switch (nbEquipement) {
		case 0: {
			System.out.println(leSoldat + getNom() + " s'équipe avec un " + equipement.getNom() + ".");
			equipements[0] = equipement;
			nbEquipement += 1;
			break;
		}
		case 1: {
			if (equipements[0] == equipement) {
				System.out.println(leSoldat + getNom() + " possède déja un " + equipement.getNom() + " !");
			} else {
				System.out.println(leSoldat + getNom() + " s'équipe avec un " + equipement.getNom() + ".");
				equipements[1] = equipement;
				nbEquipement += 1;
			}
			break;
		}
		case 2: {
			System.out.println(leSoldat + getNom() + " est déjà bien protégé !");
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

		Romain minus = new Romain("Minus", 6);
		minus.parler("Bonjour !!!!");

		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;

		System.out.println("Équipement 1 : " + casque);
		System.out.println("Équipement 2 : " + bouclier);

		System.out.println();

		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque);
	}

//	public void recevoirCoup(int forceCoup) {
//	assert isInvariantVerified() : "Pré-Condition a la reception d'un coup";
//	this.force = this.force - forceCoup;
//	if (this.force <= 0) {
//		this.prendreParole();
//		this.parler("J'abandonne !");
//	} else {
//		this.prendreParole();
//		this.parler("Aïe");
//	}
//	assert isInvariantVerified() : "Invariant a la reception d'un coup";
//}
}
