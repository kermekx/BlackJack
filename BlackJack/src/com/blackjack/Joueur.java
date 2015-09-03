package com.blackjack;
public class Joueur {

	String nom, prenom, pseudo;
	int pts;
	Hand hand;

	public Joueur(String nom, String prenom, String pseudo) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.pts = 0;
		this.hand = new Hand();
	}

	public String toString() {
		return "" + this.nom + " " + this.prenom + " (" + this.pseudo
				+ "). Points: " + this.pts + ". Main : " + this.hand.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur toto = new Joueur("Toto", "Titi", "Tata");
		System.out.println(toto.toString());
	}

}
