package com.blackjack;

public class Joueur {

	String pseudo;
	int pts;
	Hand hand;

	public Joueur(String pseudo) {
		// TODO Auto-generated constructor stub
		this.pseudo = pseudo;
		this.pts = 0;
		this.hand = new Hand();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}
	
	
	public String toString() {
		return ""+ this.pseudo
				+ ", points: " + this.pts + ". Main : " + this.hand.toString();
	}
	
	/*
	 * Le joueur pioche la premiere carte du paquet et l'ajoute à sa main
	 * 
	 */
	public void prendreCarte(Carte carte){
		this.hand.ajouterCarte(carte);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur toto = new Joueur("Toto");
		System.out.println(toto.toString());
	}

}