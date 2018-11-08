package katatennis.tennis;


public class MainTennis {

	public static void main(String[] args) {
		Joueur joueur1 = new Joueur("Marc");
		Joueur joueur2 = new Joueur("Titouan");

		Tennis tennis = new Tennis(joueur1,joueur2,3,6,7);

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				System.out.println(tennis.partie());
			}

		}

		for(int set = 0; set < 4;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				System.out.println(tennis.partie());
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			System.out.println(tennis.partie());
		}		

	}

}
