package katatennis.tennis;


import java.util.ArrayList;
import java.util.Arrays;

public class Joueur {

	private int points;
	private ArrayList<Integer> jeu ;
	private int set;
	private String nom;

	public Joueur(String nom){
		this.setNom(nom);
		this.points = 0;
		this.set = 0;
		this.jeu = new ArrayList<Integer>(Arrays.asList(0, 15, 30, 40));
	}

	public void marquerPoint(){
		this.points = points +1;
	}

	public void gagnerJeu(){
		this.set = set +1;
	}

	public void gagnerTieBreak(){
		if (this.set == 6) {
			this.set = set +1;
		}
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getJeu() {
		return this.jeu.get(points);
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}
