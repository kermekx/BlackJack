package com.blackjack;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Main {
	

	public static void main(String[] args) {
		

		int nbrJoueurs = 0;
		
		do {
			
			String nJ = JOptionPane.showInputDialog(null, "Entrez le nombre de joueurs\n(entre 1 à 4)");
			
			try {
				
				int entry = Integer.parseInt(nJ);
				
				if (entry > 0 && entry < 5)
					nbrJoueurs = entry;
				
			} catch (Exception ex) {
				if (nJ == null)
					System.exit(0);
			}
			
			
		} while (nbrJoueurs == 0);
		
		List<Joueur> joueurs = new ArrayList<Joueur>();
		
		for (int i = 0; i < nbrJoueurs; i ++) {
			String nomJ = JOptionPane.showInputDialog(null, "Entrez le nom du joueur " + (i + 1));
			joueurs.add(new Joueur(nomJ));
			if (nomJ == null)
				System.exit(0);
		}
		
		Jeu jeu = new Jeu(joueurs);
		
	}

}
