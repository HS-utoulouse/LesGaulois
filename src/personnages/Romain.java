package personnages;

public class Romain {

	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
		this.force = this.force - forceCoup;
		if (this.force <= 0) {
			this.prendreParole();
			this.parler("J'abandonne !");
		} else {
			this.prendreParole();
			this.parler("Aïe");
		}
	}

	@Override
	public String toString() {
		return this.nom;
	}

}
