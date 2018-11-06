package katatennis.tennis.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import katatennis.tennis.Joueur;
import katatennis.tennis.Tennis;

public class TestTennis {

	public static Joueur joueur1;
	public static Joueur joueur2;
	public static Tennis partietennis;
	public final String debutpartie = " Jeu :0 - 0 Set :0 - 0";
	public final String scoreserre = " Jeu :40 - 30";
	public final String scoresetnul = " Set :0 - 0";
	public final String scoresetegalitecinqcinq = " Set :5 - 5";
	public final String scoresetegalitesixsix = " Set :6 - 6";
	public final String scoresetegaliteseptcinq = " Set :7 - 5";
	public final String scoresetegalitesixzero = " Set :6 - 0";
	public final String scoresetegalitesixquatre = " Set :6 - 4";
	public final String scoresetegaliteseptsix = " Set :7 - 6";
	public final String scoresetjoueur1 = " Set :1 - 0";
	public final String scoresetiebreaknul = " TieBreak :0 - 0";
	public final String scoresetiebreakjoueur1 = " TieBreak :6 - 0";
	public final String scoresetiebreaksixsix = " TieBreak :6 - 6";
	public final String scoresetiebreakseptsept = " TieBreak :7 - 7";
	public final String scoresetiebreakhuithuit = " TieBreak :8 - 8";
	public final String scoresetiebreakseptsix = " TieBreak :7 - 6";
	public final String joueur1gagneset = "Marc a gagne le set !";
	public final String joueur1gagnejeu = "Marc a gagne le jeu !";
	public final String joueur1avantage = "Marc Avantage !";
	public final String egalite = "Egalite ";

	@Before
	public void setUpBeforeClass() throws Exception {
		joueur1 = new Joueur("Marc");
		joueur2 = new Joueur("Jean");
		partietennis = new Tennis(joueur1,joueur2,3,6,7);

	}

	@Test
	public void debutPartie() {

		assertEquals(partietennis.partie(), debutpartie);
	}

	@Test
	public void joueur1gagnejeu() {
		for(int jeu=0; jeu<4; jeu++) {
			joueur1.marquerpoint();
		}

		assertEquals(partietennis.partie(), joueur1gagnejeu + scoresetjoueur1);
	}

	@Test
	public void joueur1joueur2scorejeuserre() {

		for(int jeu=0; jeu<3; jeu++) {
			joueur1.marquerpoint();
		}

		for(int jeu=0; jeu<2; jeu++) {
			joueur2.marquerpoint();
		}
		assertEquals(partietennis.scorejeu(), scoreserre);
	}

	@Test
	public void joueur1joueur2egalitejeu() {

		for(int jeu=0; jeu<4; jeu++) {
			joueur1.marquerpoint();
		}

		for(int jeu=0; jeu<4; jeu++) {
			joueur2.marquerpoint();
		}
		assertEquals(partietennis.partie(), egalite + scoresetnul);
	}

	@Test
	public void joueur1avantage() {

		for(int jeu=0; jeu<5; jeu++) {
			joueur1.marquerpoint();
		}

		for(int jeu=0; jeu<4; jeu++) {
			joueur2.marquerpoint();
		}
		assertEquals(partietennis.partie(), joueur1avantage + scoresetnul);
	}

	@Test
	public void joueur1gagneSet() {

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerpoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 3;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}

		joueur1.marquerpoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegalitesixzero);
	}

	@Test
	public void joueur1gagnesetsixquatre() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerpoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 4;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerpoint();
				partietennis.partie();
			}

		}

		for(int jeu = 0; jeu < 3;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}

		joueur1.marquerpoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegalitesixquatre);
	}

	@Test
	public void joueur1joueur2egalitesetcinqcinq() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerpoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerpoint();
				partietennis.partie();
			}
		}

		assertEquals(partietennis.scoreset(), scoresetegalitecinqcinq);
	}

	@Test
	public void joueur1joueur2egalitesetsixsix() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerpoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerpoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerpoint();
			partietennis.partie();
		}

		assertEquals(partietennis.scoretiebreak(),scoresetiebreaknul);
	}

	@Test
	public void joueur1gagnetiebreakseptzero() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerpoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerpoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerpoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}

		assertEquals(partietennis.scoretiebreak(), scoresetiebreakjoueur1);
		joueur1.marquerpoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegaliteseptsix);
	}

	@Test
	public void joueur1gagnetiebreakhuitsix() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerpoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerpoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerpoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur2.marquerpoint();
			partietennis.partie();
		}
		
		assertEquals(partietennis.scoreset(), scoresetegalitesixsix);
		assertEquals(partietennis.scoretiebreak(), scoresetiebreaksixsix);
		joueur1.marquerpoint();
		assertEquals(partietennis.scoretiebreak(), scoresetiebreakseptsix);
		joueur1.marquerpoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegaliteseptsix);
	}

	@Test
	public void joueur1egalitetiebreakhuithuit() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerpoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerpoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerpoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur2.marquerpoint();
			partietennis.partie();
		}

		assertEquals(partietennis.scoretiebreak(), scoresetiebreaksixsix);
		joueur1.marquerpoint();
		joueur2.marquerpoint();
		assertEquals(partietennis.scoretiebreak(), scoresetiebreakseptsept);
		joueur1.marquerpoint();
		joueur2.marquerpoint();
		assertEquals(partietennis.scoretiebreak(), scoresetiebreakhuithuit);
	}

	@Test
	public void joueur1gagnesetseptcinq() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerpoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerpoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 7;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}
		joueur1.marquerpoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegaliteseptcinq);
	}

	@Test
	public void verificationjoueur1meneJeu() {
		joueur1.marquerpoint();
		assertEquals(partietennis.joueurgagnantjeu(),joueur1);
	}

	@Test
	public void verificationjoueur1meneSet() {
		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerpoint();
			partietennis.partie();
		}
		assertEquals(partietennis.joueurgagnantset(),joueur1);
	}
	
	@Test
	public void joueur1nom() {

		assertEquals(joueur1.getNom(), "Marc");
	}
	
	@Test
	public void joueur1marquerpoint() {
		joueur1.marquerpoint();
		assertEquals(joueur1.getPoints(), 1);
	}
	
	@Test
	public void joueur1Marquerpointjeu() {
		joueur1.marquerpoint();
		assertEquals(joueur1.getJeu(), 15);
	}
	
	@Test
	public void joueur1gagnerjeu() {
		joueur1.gagnerjeu();
		assertEquals(joueur1.getSet(), 1);
	}

}

