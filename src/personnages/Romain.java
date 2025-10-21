package personnages;

public class Romain {

	private String nom;
	private int force;

	private Boolean isInvariantVerified() {
		return force >= 0;
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
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

	@Override
	public String toString() {
		return this.nom;
	}

	public static void main(String[] args) {
		Romain Minus = new Romain("Minus", 6);
		Minus.parler("Bonjour !!!!");
		
		Gaulois Asterix = new Gaulois("Astérix", 18);
		
		Asterix.frapper(Minus);
		Asterix.frapper(Minus);
		Asterix.frapper(Minus);
	}

}
