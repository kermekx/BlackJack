package com.blackjack;

import java.util.Scanner;


public class Main {
	
	static Joueur j1;
	static Pioche pioche = new Pioche();
	public static void startGame(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer votre pseudo pour cette partie : ");
		String pseudo = sc.nextLine();
		j1 = new Joueur(pseudo);
		System.out.println("Bienvenue sur le jeu du BlackJack "+j1.getPseudo()+", la partie va commencer." );
		
	}
	public static void main(String[] args) {
		
		Pioche pioche = new Pioche();
		System.out.println(pioche);
		
		System.out.println(pioche.getTaillePioche());
		System.out.println(pioche.piocherCarte());
		System.out.println(pioche.getTaillePioche());
		
	}

}
