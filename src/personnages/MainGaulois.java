package personnages; 

public class MainGaulois {
	
	private static final int ForceAsterix = 8;
	private static final int ForceObelix = 16;
	private static final int ForceMinus = 6;
	private static final int ForceBrutus = 14;
	private static final int ForcePanoramix = 2;

	public static void main(String[] args) {

		Gaulois Asterix = new Gaulois("Asterix", ForceAsterix);

		Gaulois Obelix = new Gaulois("Obélix", ForceObelix);
		
		Asterix.parler("Bonjour Obélix.");
		Obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?)");
		Asterix.parler("Oui très bonne idée.");
		
		System.out.println("=================================================");

		Romain Minus = new Romain("Minus", ForceMinus);

		System.out.println("Dans la forêt " + Asterix + " et " + Obelix + " tombent nez à nez sur le romain Minus");

		for (int i = 0; i < 3; i++) {
			Asterix.frapper(Minus);
		}
		
		System.out.println("=================================================");
		
		Romain Brutus = new Romain("Brutus", ForceBrutus);

		Druide Panoramix = new Druide("Panoramix", ForcePanoramix);

		Panoramix.fabriquerPotion(4, 3);

		Panoramix.boosterGaulois(Obelix);
		Panoramix.boosterGaulois(Asterix);
		
		System.out.println("=================================================");

		for (int i = 0; i < 3; i++) {
			Asterix.frapper(Brutus);
		}
	}

}
