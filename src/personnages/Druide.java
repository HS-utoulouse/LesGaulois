package personnages;

public class Druide {

	private String nom;
	private int force;
	private Chaudron chaudron;

	public Druide(String nom, int force) {
		this.force = force;
		this.nom = nom;
		this.chaudron = new Chaudron();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		this.parler("J'ai concoté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
	}

	public void booster(Gaulois gaulois) {
		if ("Obélix".equals(gaulois.getNom())) {
			parler("Nom," + gaulois.getNom() + ", Non!...Et tu le sais trés bien !");
		} else if (chaudron.resterPotion()) {
			gaulois.boirePotion(chaudron.prendreLouche());
			parler("Tiens," + gaulois.getNom() + ", un peu de potion magique.");
		} else {
			parler("Désolé" + gaulois.getNom() + ", il n'y a plsu une seule goute de potion.");
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

	@Override
	public String toString() {
		return nom;
	}

}
