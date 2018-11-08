package katatennis.tennis.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import katatennis.tennis.Joueur;
import katatennis.tennis.Tennis;

public class TestTennis {

	public static Joueur joueur1;
	public static Joueur joueur2;
	public static Tennis partieTennis;
	public final String debutPartie = " Jeu :0 - 0 Set :0 - 0";
	public final String scoreSerre = " Jeu :40 - 30";
	public final String scoreSetNul = " Set :0 - 0";
	public final String scoreSetEgaliteCinqCinq = " Set :5 - 5";
	public final String scoreSetEgaliteSixSix = " Set :6 - 6";
	public final String scoreSetEgaliteSeptCinq = " Set :7 - 5";
	public final String scoreSetEgaliteSixZero = " Set :6 - 0";
	public final String scoreSetEgaliteSixQuatre = " Set :6 - 4";
	public final String scoreSetEgaliteSeptSix = " Set :7 - 6";
	public final String scoreSetJoueur1 = " Set :1 - 0";
	public final String scoreTieBreakNul = " TieBreak :0 - 0";
	public final String scoreTieBreakJoueur1 = " TieBreak :6 - 0";
	public final String scoreTieBreakSixSix = " TieBreak :6 - 6";
	public final String scoreTieBreakSeptSept = " TieBreak :7 - 7";
	public final String scoreTieBreakHuitHuit = " TieBreak :8 - 8";
	public final String scoreTieBreakSeptSix = " TieBreak :7 - 6";
	public final String joueur1GagneSet = "Marc a gagne le set !";
	public final String joueur1GagneJeu = "Marc a gagne le jeu !";
	public final String joueur1Avantage = "Marc Avantage !";
	public final String egalite = "Egalite ";
	public final String nomJoueur1 = "Marc";
	public final int unPoint = 1;
	public final int jeuquinze = 15;

	@Before
	public void setUpBeforeClass() throws Exception {
		joueur1 = new Joueur("Marc");
		joueur2 = new Joueur("Jean");
		partieTennis = new Tennis(joueur1,joueur2,3,6,7);

	}

	@Test
	public void debutPartie() {

		assertEquals(partieTennis.partie(), debutPartie);
	}

	@Test
	public void joueur1GagneJeu() {
		for(int jeu=0; jeu<4; jeu++) {
			joueur1.marquerPoint();
		}

		assertEquals(partieTennis.partie(), joueur1GagneJeu + scoreSetJoueur1);
	}

	@Test
	public void joueur1joueur2ScoreJeuSerre() {

		for(int jeu=0; jeu<3; jeu++) {
			joueur1.marquerPoint();
		}

		for(int jeu=0; jeu<2; jeu++) {
			joueur2.marquerPoint();
		}
		assertEquals(partieTennis.scoreJeu(), scoreSerre);
	}

	@Test
	public void joueur1joueur2EgaliteJeu() {

		for(int jeu=0; jeu<4; jeu++) {
			joueur1.marquerPoint();
		}

		for(int jeu=0; jeu<4; jeu++) {
			joueur2.marquerPoint();
		}
		assertEquals(partieTennis.partie(), egalite + scoreSetNul);
	}

	@Test
	public void joueur1Avantage() {

		for(int jeu=0; jeu<5; jeu++) {
			joueur1.marquerPoint();
		}

		for(int jeu=0; jeu<4; jeu++) {
			joueur2.marquerPoint();
		}
		assertEquals(partieTennis.partie(), joueur1Avantage + scoreSetNul);
	}

	@Test
	public void joueur1GagneSet() {

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int jeu = 0; jeu < 3;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}

		joueur1.marquerPoint();
		assertEquals(partieTennis.partie(), joueur1GagneSet + scoreSetEgaliteSixZero);
	}

	@Test
	public void joueur1GagneSetSixQuatre() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int set = 0; set < 4;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partieTennis.partie();
			}

		}

		for(int jeu = 0; jeu < 3;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}

		joueur1.marquerPoint();
		assertEquals(partieTennis.partie(), joueur1GagneSet + scoreSetEgaliteSixQuatre);
	}

	@Test
	public void joueur1joueur2EgaliteSetCinqCinq() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partieTennis.partie();
			}
		}

		assertEquals(partieTennis.scoreSet(), scoreSetEgaliteCinqCinq);
	}

	@Test
	public void joueur1joueur2EgaliteSetSixSix() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerPoint();
			partieTennis.partie();
		}

		assertEquals(partieTennis.scoreTieBreak(),scoreTieBreakNul);
	}

	@Test
	public void joueur1GagneTieBreakSeptZero() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerPoint();
			partieTennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}

		assertEquals(partieTennis.scoreTieBreak(), scoreTieBreakJoueur1);
		joueur1.marquerPoint();
		assertEquals(partieTennis.partie(), joueur1GagneSet + scoreSetEgaliteSeptSix);
	}

	@Test
	public void joueur1GagneTieBreakHuitSix() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerPoint();
			partieTennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur2.marquerPoint();
			partieTennis.partie();
		}
		
		assertEquals(partieTennis.scoreSet(), scoreSetEgaliteSixSix);
		assertEquals(partieTennis.scoreTieBreak(), scoreTieBreakSixSix);
		joueur1.marquerPoint();
		assertEquals(partieTennis.scoreTieBreak(), scoreTieBreakSeptSix);
		joueur1.marquerPoint();
		assertEquals(partieTennis.partie(), joueur1GagneSet + scoreSetEgaliteSeptSix);
	}

	@Test
	public void joueur1EgaliteTieBreakHuitHuit() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}

		for(int jeu = 0; jeu < 4;jeu++) {
			joueur2.marquerPoint();
			partieTennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}

		for(int jeu = 0; jeu < 6;jeu++) {
			joueur2.marquerPoint();
			partieTennis.partie();
		}

		assertEquals(partieTennis.scoreTieBreak(), scoreTieBreakSixSix);
		joueur1.marquerPoint();
		joueur2.marquerPoint();
		assertEquals(partieTennis.scoreTieBreak(), scoreTieBreakSeptSept);
		joueur1.marquerPoint();
		joueur2.marquerPoint();
		assertEquals(partieTennis.scoreTieBreak(), scoreTieBreakHuitHuit);
	}

	@Test
	public void joueur1GagneSetSeptCinq() {

		for(int set = 0; set < 5;set++) {
			for(int jeu = 0; jeu < 4;jeu++) {
				joueur1.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int set = 0; set < 5;set++) {

			for(int jeu = 0; jeu < 4;jeu++) {
				joueur2.marquerPoint();
				partieTennis.partie();
			}
		}

		for(int jeu = 0; jeu < 7;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}
		joueur1.marquerPoint();
		assertEquals(partieTennis.partie(), joueur1GagneSet + scoreSetEgaliteSeptCinq);
	}

	@Test
	public void verificationJoueur1MeneJeu() {
		joueur1.marquerPoint();
		assertEquals(partieTennis.joueurGagnantJeu(),joueur1);
	}

	@Test
	public void verificationJoueur1MeneSet() {
		for(int jeu = 0; jeu < 4;jeu++) {
			joueur1.marquerPoint();
			partieTennis.partie();
		}
		assertEquals(partieTennis.joueurGagnantSet(),joueur1);
	}
	
	@Test
	public void joueur1Nom() {

		assertEquals(joueur1.getNom(), nomJoueur1);
	}
	
	@Test
	public void joueur1MarquerPoint() {
		joueur1.marquerPoint();
		assertEquals(joueur1.getPoints(), unPoint);
	}
	
	@Test
	public void joueur1MarquerPointJeu() {
		joueur1.marquerPoint();
		assertEquals(joueur1.getJeu(), jeuquinze);
	}
	
	@Test
	public void joueur1GagnerJeu() {
		joueur1.gagnerJeu();
		assertEquals(joueur1.getSet(), unPoint);
	}

}

