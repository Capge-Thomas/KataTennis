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
	public final String nomjoueur1 = "Marc";
	public final int unpoint = 1;
	public final int jeuquinze = 15;

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
	public void joueur1GagneJeu() {
		for(int jeu=0; jeu<4; jeu++) {
			joueur1.marquerPoint();
		}

		assertEquals(partietennis.partie(), joueur1gagnejeu + scoresetjoueur1);
	}

	@Test
	public void joueur1joueur2ScoreJeuSerre() {

		for(int jeu=0; jeu<3; jeu++) {
			joueur1.marquerPoint();
		}

		for(int jeu=0; jeu<2; jeu++) {
			joueur2.marquerPoint();
		}
		assertEquals(partietennis.scoreJeu(), scoreserre);
	}

	@Test
	public void joueur1joueur2EgaliteJeu() {

		for(int jeu=0; jeu<4; jeu++) {
			joueur1.marquerPoint();
		}

		for(int jeu=0; jeu<4; jeu++) {
			joueur2.marquerPoint();
		}
		assertEquals(partietennis.partie(), egalite + scoresetnul);
	}

	@Test
	public void joueur1Avantage() {

		for(int jeu=0; jeu<5; jeu++) {
			joueur1.marquerPoint();
		}

		for(int jeu=0; jeu<4; jeu++) {
			joueur2.marquerPoint();
		}
		assertEquals(partietennis.partie(), joueur1avantage + scoresetnul);
	}

	@Test
	public void joueur1GagneSet() {

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 3;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}

		joueur1.marquerPoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegalitesixzero);
	}

	@Test
	public void joueur1GagneSetSixQuatre() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 4;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partietennis.partie();
			}

		}

		for(int jeu = 0; jeu < 3;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}

		joueur1.marquerPoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegalitesixquatre);
	}

	@Test
	public void joueur1joueur2EgaliteSetCinqCinq() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partietennis.partie();
			}
		}

		assertEquals(partietennis.scoreSet(), scoresetegalitecinqcinq);
	}

	@Test
	public void joueur1joueur2EgaliteSetSixSix() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerPoint();
			partietennis.partie();
		}

		assertEquals(partietennis.scoreTieBreak(),scoresetiebreaknul);
	}

	@Test
	public void joueur1GagneTieBreakSeptZero() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerPoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}

		assertEquals(partietennis.scoreTieBreak(), scoresetiebreakjoueur1);
		joueur1.marquerPoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegaliteseptsix);
	}

	@Test
	public void joueur1GagneTieBreakHuitSix() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerPoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur2.marquerPoint();
			partietennis.partie();
		}
		
		assertEquals(partietennis.scoreSet(), scoresetegalitesixsix);
		assertEquals(partietennis.scoreTieBreak(), scoresetiebreaksixsix);
		joueur1.marquerPoint();
		assertEquals(partietennis.scoreTieBreak(), scoresetiebreakseptsix);
		joueur1.marquerPoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegaliteseptsix);
	}

	@Test
	public void joueur1EgaliteTieBreakHuitHuit() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerPoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur2.marquerPoint();
			partietennis.partie();
		}

		assertEquals(partietennis.scoreTieBreak(), scoresetiebreaksixsix);
		joueur1.marquerPoint();
		joueur2.marquerPoint();
		assertEquals(partietennis.scoreTieBreak(), scoresetiebreakseptsept);
		joueur1.marquerPoint();
		joueur2.marquerPoint();
		assertEquals(partietennis.scoreTieBreak(), scoresetiebreakhuithuit);
	}

	@Test
	public void joueur1GagneSetSeptCinq() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partietennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partietennis.partie();
			}
		}

		for(int jeu = 0; jeu < 7;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}
		joueur1.marquerPoint();
		assertEquals(partietennis.partie(), joueur1gagneset + scoresetegaliteseptcinq);
	}

	@Test
	public void verificationJoueur1MeneJeu() {
		joueur1.marquerPoint();
		assertEquals(partietennis.joueurGagnantJeu(),joueur1);
	}

	@Test
	public void verificationJoueur1MeneSet() {
		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partietennis.partie();
		}
		assertEquals(partietennis.joueurGagnantSet(),joueur1);
	}
	
	@Test
	public void joueur1Nom() {

		assertEquals(joueur1.getNom(), nomjoueur1);
	}
	
	@Test
	public void joueur1MarquerPoint() {
		joueur1.marquerPoint();
		assertEquals(joueur1.getPoints(), unpoint);
	}
	
	@Test
	public void joueur1MarquerPointJeu() {
		joueur1.marquerPoint();
		assertEquals(joueur1.getJeu(), jeuquinze);
	}
	
	@Test
	public void joueur1GagnerJeu() {
		joueur1.gagnerJeu();
		assertEquals(joueur1.getSet(), unpoint);
	}

}

