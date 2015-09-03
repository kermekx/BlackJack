package com.blackjack;

import java.util.List;
import java.util.Map;

public class Jeu {
	
	private List<Joueur> joueurs;
	
	private Pioche pioche;
	
	public Jeu(List<Joueur> joueurs) {
		
		this.joueurs = joueurs;
		
		Pioche pioche = new Pioche();
		
		this.initHands();
		
		for(Joueur joueur : joueurs) {
			System.out.println(joueur.toString());
		}
			
		
	}
	
	public void initHands() {
		
		for (Joueur joueur : joueurs) {
			joueur.prendreCarte(pioche.piocherCarte());
			joueur.prendreCarte(pioche.piocherCarte());
		}
		
	}

}
