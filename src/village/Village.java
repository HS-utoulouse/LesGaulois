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

}
