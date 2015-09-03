package com.blackjack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Jeu {
	
	private List<Joueur> joueurs;
	private Map<Joueur, Boolean> fini = new HashMap<Joueur, Boolean>();
	
	private Pioche pioche;
	
	public Jeu(List<Joueur> joueurs) {
		
		this.joueurs = joueurs;
		
		pioche = new Pioche();
		
		this.initHands();
		
		for(Joueur joueur : joueurs) {
			System.out.println(joueur.toString());
		}
		
		while (!fini()) {
			tour();
		}
		
	}
	
	public void initHands() {
		
		for (Joueur joueur : joueurs) {
			joueur.prendreCarte(pioche.piocherCarte());
			joueur.prendreCarte(pioche.piocherCarte());
			fini.put(joueur, false);
		}
		
	}
	
	public boolean fini() {
		
		boolean fin = true;
		
		for (Joueur joueur : joueurs)
			if (fini.get(joueur) == false)
				fin = false;
		
		return fin;
		
	}
	
	public void tour() {
		for (Joueur joueur : joueurs)
			if (fini.get(joueur) == false) {
				JOptionPane.showConfirmDialog(null, joueur.toString() + "\n  voulez vous piochez?");
				
			}
				
		
	}

}
