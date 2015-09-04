package com.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import com.blackjack.renderer.Box;
import com.blackjack.renderer.Label;
import com.blackjack.renderer.Renderer;

public class Jeu {

	private List<Joueur> joueurs;
	private Map<Joueur, StringBuffer> fini = new HashMap<Joueur, StringBuffer>();

	private Pioche pioche;
	private JComponent renderer;

	public Jeu(List<Joueur> joueurs, JComponent renderer) {

		this.renderer = renderer;
		this.joueurs = joueurs;

		List<Label> labels = new ArrayList<Label>();
		for (int i = 0; i < joueurs.size(); i++) {
			labels.add(new Label("<html><center>" + joueurs.get(i).getPseudo()
					+ " :</center></html>", (800 / joueurs.size()) * (i), 300));
		}

		for (Label l : labels)
			renderer.add(l);
		
		renderer.repaint();

		pioche = new Pioche();

		this.initHands();

		for (Joueur joueur : joueurs) {
			System.out.println(joueur.toString());
		}

		while (!fini()) {
			tour();
		}
		Joueur ia = new Joueur("Banque");
		ia.prendreCarte(pioche.piocherCarte());
		ia.prendreCarte(pioche.piocherCarte());
		// blackjack?
		while (ia.getPts() < 17) {
			ia.prendreCarte(pioche.piocherCarte());
		}
		joueurs.add(ia);

		Joueur gagnant = null;
		int max = 0;
		boolean egalite = false;

		for (Joueur joueur : joueurs) {
			if (joueur.getPts() < 22 && joueur.getPts() > max) {
				gagnant = joueur;
				max = joueur.getPts();
				egalite = false;
			} else if (joueur.getPts() == max) {
				egalite = true;
			}
		}

		if (egalite)
			JOptionPane.showMessageDialog(null,
					"Pas de gagnant suite a une egalite!");
		else if (gagnant == null)
			JOptionPane.showMessageDialog(null,
					"Pas de gagnant! Tout le monde a depasse 21!");
		else {
			JOptionPane.showMessageDialog(null, gagnant.getPseudo()
					+ " a gagné avec " + max + " points!");
		}
	}

	public void initHands() {

		for (Joueur joueur : joueurs) {
			joueur.prendreCarte(pioche.piocherCarte());
			joueur.prendreCarte(pioche.piocherCarte());
			fini.put(joueur, new StringBuffer("f"));
		}

		for (Joueur joueur : joueurs) {
			if (joueur.getPts() == 21) {
				for (Joueur j : joueurs)
					fini.get(j).setCharAt(0, 't');
				JOptionPane.showMessageDialog(null, "BLACKJACK ! Bien joué "
						+ joueur.getPseudo() + "!");
			}
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
		Joueur gagnant = new Joueur("");

		for (Joueur joueur : joueurs)
			if (fini.get(joueur).charAt(0) == 'f') {

				int entry = -1;
				do {
					entry = JOptionPane.showConfirmDialog(null,
							joueur.toString() + "\n  voulez vous piocher?");
				} while (entry < 0 && entry > 1);

				if (entry == 0) {
					Carte tirage = pioche.piocherCarte();
					JOptionPane.showMessageDialog(null, "Vous avez pioché : "
							+ tirage);
					joueur.prendreCarte(tirage);
					if (joueur.getPts() > 21) {
						fini.get(joueur).setCharAt(0, 't');
						JOptionPane.showMessageDialog(
								null,
								"Vous avez perdu! Votre score est de "
										+ joueur.getPts());
					}
					if (joueur.getPts() == 21) {
						fini.get(joueur).setCharAt(0, 't');
						gagnant.setPseudo(joueur.getPseudo());
						JOptionPane.showMessageDialog(null, "Vous avez fait "
								+ joueur.getPts() + "!");

					}
				} else

					fini.get(joueur).setCharAt(0, 't');

			}

	}

}
