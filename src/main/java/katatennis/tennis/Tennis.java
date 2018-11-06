package katatennis.tennis;

public class Tennis {

	private Joueur joueur1;
	private Joueur joueur2;
	private int nbpointsgagnant;
	private int nbjeugagnant;
	private int nbtiebreakgagnant;
	public String avantage = " Avantage !";
	public String jeugagné = " a gagne le jeu !";
	public String setgagné = " a gagne le set !";
	public String egalite = "Egalite ";


	public Tennis(Joueur joueur1,Joueur joueur2,int nbpointsgagnant,int nbjeugagnant, int nbtiebreakgagnant ){
		this.setJoueur1(joueur1);
		this.setJoueur2(joueur2);
		this.setnbpointsgagnant(nbpointsgagnant);
		this.setnbjeugagnant(nbjeugagnant);
		this.setnbtiebreakgagnant(nbtiebreakgagnant);
	}

	public String partie(){
		if(joueur1.getSet() < this.nbjeugagnant && joueur2.getSet() < this.nbjeugagnant) {
			return deroulementjeu();
		} else if (joueur1.getSet() == this.nbjeugagnant &&  joueur2.getSet() == this.nbjeugagnant) {
			return deroulementtiebreak();
		} else if (joueur1.getSet() >= this.nbjeugagnant ||  joueur2.getSet() >= this.nbjeugagnant) {
			if(Math.abs(joueur1.getSet() - joueur2.getSet())>=2){
				String gagnantset = joueurgagnantset().getNom();
				reinitialiserset();
				return gagnantset + this.setgagné;
			} else {
				return deroulementjeu();
			}
		} else {
			return scorejeu() + scoreset();
		}
	}

	public String deroulementjeu() {
		if(joueur1.getPoints() >= nbpointsgagnant && joueur2.getPoints() >= nbpointsgagnant) {
			if(Math.abs(joueur1.getPoints() - joueur2.getPoints())>=2){
				joueurgagnantjeu().gagnerjeu();
				return verificationresultatset(this.nbjeugagnant,2);

			} else if(joueur1.getPoints() == joueur2.getPoints()) {
				return egalite+ scoreset();
			} else {
				return joueurgagnantjeu().getNom() + this.avantage + scoreset();
			}
		} else if(joueur1.getPoints() > nbpointsgagnant || joueur2.getPoints() > nbpointsgagnant){
			joueurgagnantjeu().gagnerjeu();
			return verificationresultatset(this.nbjeugagnant,2);

		} else {
			return  scorejeu() + scoreset();
		}
	}

	public String deroulementtiebreak() {
		if(joueur1.getPoints() >= this.nbtiebreakgagnant || joueur2.getPoints() >= this.nbtiebreakgagnant) {
			if(Math.abs(joueur1.getPoints() - joueur2.getPoints())>=2){
				joueurgagnantjeu().gagnertiebreak();
				return verificationresultatset(this.nbtiebreakgagnant,1);

			} else {
				return scoretiebreak() + scoreset();
			}
		} else {
			return scoretiebreak() + scoreset();
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

	public Joueur joueurgagnantjeu(){
		if (joueur1.getPoints()> joueur2.getPoints()) {
			return joueur1;
		} else {
			return joueur2;
		}
	}

	public void reinitialiserpoints() {
		this.joueur1.setPoints(0);
		this.joueur2.setPoints(0);
	}

	public void reinitialiserset() {
		this.joueur1.setSet(0);
		this.joueur2.setSet(0);
	}


	public Joueur joueurgagnantset(){
		if (joueur1.getSet()> joueur2.getSet())
			return joueur1;
		else
			return joueur2;
	}

	public String verificationresultatset(int nbjeugagnant, int differencesetmin){
		String gagnantjeu = joueurgagnantjeu().getNom();
		reinitialiserpoints();
		if (joueur1.getSet() >= nbjeugagnant||  joueur2.getSet() >= nbjeugagnant) {
			if(Math.abs(joueur1.getSet() - joueur2.getSet())>=differencesetmin){
				String scoreset = scoreset();
				String gagnantset = joueurgagnantset().getNom();
				reinitialiserset();
				return gagnantset + this.setgagné + scoreset;
			}
			return gagnantjeu + this.jeugagné + scoreset();
		} else {
			return gagnantjeu + this.jeugagné + scoreset();
		}

	}

	public String scoreset() {
		return " Set :" + joueur1.getSet() + " - " + joueur2.getSet();
	}

	public String scorejeu() {
		return " Jeu :" + joueur1.getJeu() + " - " + joueur2.getJeu();
	}

	public String scoretiebreak() {
		return " TieBreak :" + joueur1.getPoints() + " - " + joueur2.getPoints();
	}

	public int getnbjeugagnant() {
		return nbpointsgagnant;
	}

	public void setnbpointsgagnant(int nbpointsgagnant) {
		this.nbpointsgagnant = nbpointsgagnant;
	}

	public int getnbsetgagnant() {
		return nbjeugagnant;
	}

	public void setnbjeugagnant(int nbjeugagnant) {
		this.nbjeugagnant = nbjeugagnant;
	}

	public int getnbtiebreakgagnant() {
		return nbtiebreakgagnant;
	}

	public void setnbtiebreakgagnant(int nbtiebreakgagnant) {
		this.nbtiebreakgagnant = nbtiebreakgagnant;
	}

}
