package village;

import personnages.Gaulois;
import objet.Equipement;
import objet.Trophee;

public class Musee {
	private int nbTrophee;
	private Trophee[] trophees;
	private int maxLenth = 200;

	public Musee() {
		this.nbTrophee = 0;
		this.trophees = new Trophee[maxLenth];
	}

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < maxLenth) {
			Trophee trophee = new Trophee(gaulois, equipement);
			trophees[nbTrophee] = trophee;
			nbTrophee++;
		} else {
			System.out.println("Le musée est plein, impossible d'ajouter plus de trophées !");
		}
	}

	public String extraireInstructionsOCaml() {
		String texte = "let musee = [\n";

		for (int i = 0; i < nbTrophee; i++) {
			texte += "\t\"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement() + "\";\n";
		}

		return texte + "]";
	}
}
