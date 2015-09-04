package com.blackjack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.blackjack.renderer.Bouton;
import com.blackjack.renderer.Label;

public class Jeu {

	private List<Joueur> joueurs;
	private Map<Joueur, StringBuffer> fini = new HashMap<Joueur, StringBuffer>();

	private Pioche pioche;
	private JComponent renderer;
	private List<JComponent> cartes;
	private List<Label> labels;
	
	private static boolean next = false;
	private static boolean choix = false;

	public Jeu(List<Joueur> joueurs, JComponent renderer) {

		this.renderer = renderer;
		this.joueurs = joueurs;

		labels = new ArrayList<Label>();
		for (int i = 0; i < joueurs.size(); i++) {
			labels.add(new Label("<html><center>" + joueurs.get(i).getPseudo()
					+ "</center></html>", (800 / joueurs.size()) * (i), 300));
		}

		for (Label l : labels)
			renderer.add(l);

		pioche = new Pioche();

		this.initHands();

		cartes = new ArrayList<JComponent>();

		for (int i = 0; i < joueurs.size(); i++)
			for (int j = 0; j < joueurs.get(i).getHand().getCartes().size(); j++)
				cartes.add(joueurs
						.get(i)
						.getHand()
						.getCartes()
						.get(j)
						.getImage((800 / joueurs.size()) * (i) + 75,
								350 + 30 * j));

		for (JComponent carte : cartes)
			renderer.add(carte);

		for (int i = 0; i < joueurs.size(); i++)
			labels.get(i).setText(
					"<html><center>" + joueurs.get(i).getPseudo() + " : "
							+ joueurs.get(i).getPts()
							+ " Points</center></html>");

		renderer.repaint();

		while (!fini()) {
			tour();
		}
		Joueur ia = new Joueur("Banque");
		ia.prendreCarte(pioche.piocherCarte());
		ia.prendreCarte(pioche.piocherCarte());

		if (ia.getPts() == 21) {
			fini.get(ia).setCharAt(0, 't');
			JOptionPane.showMessageDialog(null,
					"BLACKJACK ! La banque a gagnée avec :" + ia.getPts()
							+ "points !");
		}
		while (ia.getPts() < 17) {
			ia.prendreCarte(pioche.piocherCarte());
		}
		
		for (JComponent carte : cartes)
			renderer.remove(carte);
		
		for (int i = 0; i < ia.getHand().getSize(); i ++)
			cartes.add(ia.getHand().getCartes().get(i).getImage(600, 75 + i * 30));
		
		for (JComponent carte : cartes)
			renderer.add(carte);
		
		JLabel banque = new Label("<html><center>Banque : " + ia.getPts() + "</center></html>", 500, 25);
		renderer.add(banque);
		
		renderer.repaint();
			
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
		String s = "Récapitulatif : \n";
		for (int i = 0; i < joueurs.size(); i++) {
			s = s + joueurs.get(i).getPseudo() + " a fini avec "
					+ joueurs.get(i).getPts() + " points!\n";
		}
		JOptionPane.showMessageDialog(null, s);

		for (Label l : labels)
			renderer.remove(l);
		for (JComponent carte : cartes)
			renderer.remove(carte);
		renderer.remove(banque);
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

				next = false;
				choix = false;
				
				JLabel label = new Label(
						"<html><center>" + joueur.getPseudo() + " voulez vous piocher?</center></html>",
						275, 250);
				label.setFont(new Font("Arial", Font.BOLD, 24));
				JButton oui = new Bouton("Oui", 175, 275, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						next = true;
						choix = true;
					}
				});

				JButton non = new Bouton("Non", 525, 275, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						next = true;
						choix = false;
					}
				});
				
				renderer.add(label);
				renderer.add(oui);
				renderer.add(non);
				renderer.repaint();
				
				while (!next)
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

				if (choix) {
					Carte tirage = pioche.piocherCarte();
					joueur.prendreCarte(tirage);
					if (joueur.getPts() > 21) {
						fini.get(joueur).setCharAt(0, 't');
					}
					if (joueur.getPts() == 21) {
						fini.get(joueur).setCharAt(0, 't');
						gagnant.setPseudo(joueur.getPseudo());
					}
				} else
					fini.get(joueur).setCharAt(0, 't');
				
				for (JComponent carte : cartes)
					renderer.remove(carte);
				cartes = new ArrayList<JComponent>();
				for (int i = 0; i < joueurs.size(); i++)
					for (int j = 0; j < joueurs.get(i).getHand().getCartes().size(); j++)
						cartes.add(joueurs
								.get(i)
								.getHand()
								.getCartes()
								.get(j)
								.getImage((800 / joueurs.size()) * (i) + 75,
										350 + 30 * j));
				for (JComponent carte : cartes)
					renderer.add(carte);
				for (int i = 0; i < joueurs.size(); i++)
					labels.get(i).setText(
							"<html><center>" + joueurs.get(i).getPseudo() + " : "
									+ joueurs.get(i).getPts()
									+ " Points</center></html>");
				renderer.remove(label);
				renderer.remove(oui);
				renderer.remove(non);
				renderer.repaint();

			}

	}

}
