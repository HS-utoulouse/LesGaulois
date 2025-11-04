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
}
