package com.blackjack;

import java.util.ArrayList;
import java.util.List;


public class Main {
	

	public static void main(String[] args) {
		
		/**
		int nbrJoueurs = 0;
		
		do {
			
			
		} while (nbrJoueurs == 0);
		*/
		List<Joueur> joueurs = new ArrayList<Joueur>();
		
		joueurs.add(new Joueur("Corwin"));
		
		joueurs.add(new Joueur("Kevin"));
		
		Jeu jeu = new Jeu(joueurs);
		
	}

}
