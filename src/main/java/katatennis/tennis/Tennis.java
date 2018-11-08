package katatennis.tennis;

public class Tennis {

	private Joueur joueur1;
	private Joueur joueur2;
	private int nbPointsGagnant;
	private int nbJeuGagnant;
	private int nbTieBreakGagnant;
	public String avantage = " Avantage !";
	public String jeuGagné = " a gagne le jeu !";
	public String setGagné = " a gagne le set !";
	public String egalite = "Egalite ";


	public Tennis(Joueur joueur1,Joueur joueur2,int nbpointsgagnant,int nbjeugagnant, int nbtiebreakgagnant ){
		this.setJoueur1(joueur1);
		this.setJoueur2(joueur2);
		this.setNbPointsGagnant(nbpointsgagnant);
		this.setNbJeuGagnant(nbjeugagnant);
		this.setNbTieBreakGagnant(nbtiebreakgagnant);
	}

	public String partie(){
		if(joueur1.getSet() < this.nbJeuGagnant && joueur2.getSet() < this.nbJeuGagnant) {
			return deroulementJeu();
		} else if (joueur1.getSet() == this.nbJeuGagnant &&  joueur2.getSet() == this.nbJeuGagnant) {
			return deroulementTieBreak();
		} else if (joueur1.getSet() >= this.nbJeuGagnant ||  joueur2.getSet() >= this.nbJeuGagnant) {
			if(Math.abs(joueur1.getSet() - joueur2.getSet())>=2){
				String gagnantset = joueurGagnantSet().getNom();
				reinitialiserSet();
				return gagnantset + this.setGagné;
			} else {
				return deroulementJeu();
			}
		} else {
			return scoreJeu() + scoreSet();
		}
	}

	public String deroulementJeu() {
		if(joueur1.getPoints() >= nbPointsGagnant && joueur2.getPoints() >= nbPointsGagnant) {
			if(Math.abs(joueur1.getPoints() - joueur2.getPoints())>=2){
				joueurGagnantJeu().gagnerJeu();
				return verificationResultatSet(this.nbJeuGagnant,2);

			} else if(joueur1.getPoints() == joueur2.getPoints()) {
				return egalite+ scoreSet();
			} else {
				return joueurGagnantJeu().getNom() + this.avantage + scoreSet();
			}
		} else if(joueur1.getPoints() > nbPointsGagnant || joueur2.getPoints() > nbPointsGagnant){
			joueurGagnantJeu().gagnerJeu();
			return verificationResultatSet(this.nbJeuGagnant,2);

		} else {
			return  scoreJeu() + scoreSet();
		}
	}

	public String deroulementTieBreak() {
		if(joueur1.getPoints() >= this.nbTieBreakGagnant || joueur2.getPoints() >= this.nbTieBreakGagnant) {
			if(Math.abs(joueur1.getPoints() - joueur2.getPoints())>=2){
				joueurGagnantJeu().gagnerTieBreak();
				return verificationResultatSet(this.nbTieBreakGagnant,1);

			} else {
				return scoreTieBreak() + scoreSet();
			}
		} else {
			return scoreTieBreak() + scoreSet();
		}
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public Joueur joueurGagnantJeu(){
		if (joueur1.getPoints()> joueur2.getPoints()) {
			return joueur1;
		} else {
			return joueur2;
		}
	}

	public void reinitialiserPoints() {
		this.joueur1.setPoints(0);
		this.joueur2.setPoints(0);
	}

	public void reinitialiserSet() {
		this.joueur1.setSet(0);
		this.joueur2.setSet(0);
	}


	public Joueur joueurGagnantSet(){
		if (joueur1.getSet()> joueur2.getSet())
			return joueur1;
		else
			return joueur2;
	}

	public String verificationResultatSet(int nbjeugagnant, int differencesetmin){
		String gagnantjeu = joueurGagnantJeu().getNom();
		reinitialiserPoints();
		if (joueur1.getSet() >= nbjeugagnant||  joueur2.getSet() >= nbjeugagnant) {
			if(Math.abs(joueur1.getSet() - joueur2.getSet())>=differencesetmin){
				String scoreset = scoreSet();
				String gagnantset = joueurGagnantSet().getNom();
				reinitialiserSet();
				return gagnantset + this.setGagné + scoreset;
			}
			return gagnantjeu + this.jeuGagné + scoreSet();
		} else {
			return gagnantjeu + this.jeuGagné + scoreSet();
		}

	}

	public String scoreSet() {
		return " Set :" + joueur1.getSet() + " - " + joueur2.getSet();
	}

	public String scoreJeu() {
		return " Jeu :" + joueur1.getJeu() + " - " + joueur2.getJeu();
	}

	public String scoreTieBreak() {
		return " TieBreak :" + joueur1.getPoints() + " - " + joueur2.getPoints();
	}

	public int getNbJeuGagnant() {
		return nbPointsGagnant;
	}

	public void setNbPointsGagnant(int nbpointsgagnant) {
		this.nbPointsGagnant = nbpointsgagnant;
	}

	public int getNbSetGagnant() {
		return nbJeuGagnant;
	}

	public void setNbJeuGagnant(int nbjeugagnant) {
		this.nbJeuGagnant = nbjeugagnant;
	}

	public int getNbTieBreakGagnant() {
		return nbTieBreakGagnant;
	}

	public void setNbTieBreakGagnant(int nbtiebreakgagnant) {
		this.nbTieBreakGagnant = nbtiebreakgagnant;
	}

}
