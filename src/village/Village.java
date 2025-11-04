package village;

import personnages.Gaulois;

public class Village {

	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private String nom;
	private Gaulois chef;

	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[nbVillageoisMax];
		this.chef.setVillage(this);
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois++] = gaulois;
			gaulois.setVillage(this);
		} else {
			System.out.println("Le village est plein !");
		}
	}

	public Gaulois trouverVillageois(int num) {
		if ((num - 1) >= 0 && (num - 1) < nbVillageois) {
			return villageois[num - 1];
		} else {
			System.out.println("Il n’y a pas autant d'habitants dans notre village !");
		}
		return null;
	}

	public void afficherVillage() {
		System.out.println("Dans le village \"" + this.getNom() + "\" du chef " + this.getChef()
				+ " vivent les légendaires gaulois : ");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i]);
		}
	}

	public static void main(String[] args) {

		Gaulois Abraracourcix = new Gaulois("Abraracourcix", 6);

		Village village = new Village("Village des Irréductibles", Abraracourcix, 30);

		// Gaulois gaulois = village.trouverVillageois(30);

		Gaulois Asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(Asterix);

		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);

		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		Gaulois Obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(Obelix);

		village.afficherVillage();

		Gaulois Polemix = new Gaulois("DoublePolémix", 4);

		Abraracourcix.sePresenter();
		Obelix.sePresenter();
		Polemix.sePresenter();
	}
}
