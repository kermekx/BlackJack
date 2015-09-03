package com.blackjack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Jeu {

	private List<Joueur> joueurs;
	private Map<Joueur, StringBuffer> fini = new HashMap<Joueur, StringBuffer>();

	private Pioche pioche;

	public Jeu(List<Joueur> joueurs) {

		this.joueurs = joueurs;

		pioche = new Pioche();

		this.initHands();

		for (Joueur joueur : joueurs) {
			System.out.println(joueur.toString());
		}

		while (!fini()) {
			tour();
		}
		
		for (Joueur joueur : joueurs)
			JOptionPane.showMessageDialog(null, joueur.getPseudo() + " a fait "+joueur.getPts()+" points.");
		

	}

	public void initHands() {

		for (Joueur joueur : joueurs) {
			joueur.prendreCarte(pioche.piocherCarte());
			joueur.prendreCarte(pioche.piocherCarte());
			fini.put(joueur, new StringBuffer("f"));
		}

	}

	public boolean fini() {

		boolean fin = true;

		for (Joueur joueur : joueurs)
			if (fini.get(joueur).charAt(0) == 'f')
				fin = false;

		return fin;

	}

	public void tour() {
		Joueur gagnant=new Joueur("");
		
		for (Joueur joueur : joueurs)
			if (fini.get(joueur).charAt(0) == 'f') {

				int entry = -1;
				do {
					entry = JOptionPane.showConfirmDialog(null,
							joueur.toString() + "\n  voulez vous piocher?");
				} while (entry < 0 && entry > 1);

				if (entry == 0) {
					Carte tirage = pioche.piocherCarte();
					JOptionPane.showMessageDialog(null, "Vous avez pioché : " + tirage);
					joueur.prendreCarte(tirage);
					if (joueur.getPts() > 21) {
						fini.get(joueur).setCharAt(0, 't');
						JOptionPane.showMessageDialog(null, "Vous avez perdu! Votre score est de " + joueur.getPts());
					}
					if (joueur.getPts() == 21) {
						fini.get(joueur).setCharAt(0, 't');
						gagnant.setPseudo(joueur.getPseudo());
						JOptionPane.showMessageDialog(null, "Vous avez fait "+joueur.getPts()+", vous avez donc gagnez! \nBravo "+gagnant.getPseudo());
						
					}
				} else
					fini.get(joueur).setCharAt(0, 't');

			}

	}

}
