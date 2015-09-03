package com.blackjack;

public class Joueur {

	String pseudo;
	int pts;
	Hand hand;

	/**
	 * Constructeur d'un joueur, initialise ses points à 0
	 * @param pseudo choisi par le joueur 
	 */
	public Joueur(String pseudo) {
		// TODO Auto-generated constructor stub
		this.pseudo = pseudo;
		this.pts = 0;
		this.hand = new Hand();
	}
	/**
	 * Retourne le pseudo du joueur
	 * @return le pseudo du joueur
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * Modifie le pseudo du joueur
	 * @param pseudo - pseudo de remplacement
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	 /**
	  * Retourne les points du joueur
	  * @return les points des joueurs
	  */
	public int getPts() {
		pts=pts+Valeur.getPoints(this.hand.getValeurs());
		return pts;
	}
/**
 * Modifie les points du joueurs par ceux en paramètres
 * @param pts - Points qui vont remplacer ceux du joueur
 */
	public void setPts(int pts) {
		this.pts = pts;
	}
	
	/*
	 * Méthode toString qui retourne les infos du joueur
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ""+ this.pseudo
				+ ", points: " + this.pts + ". Main : " + this.hand.toString();
	}
	
	/*
	 * Le joueur pioche la premiere carte du paquet et l'ajoute à sa main
	 * 
	 */
	public void prendreCarte(){
		this.hand.ajouterCarte(Main.pioche.piocherCarte());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur toto = new Joueur("Toto");
		System.out.println(toto.toString());
	}
	


}
