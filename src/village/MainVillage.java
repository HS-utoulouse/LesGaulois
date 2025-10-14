package village;

import personnages.Gaulois;

public class MainVillage {
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