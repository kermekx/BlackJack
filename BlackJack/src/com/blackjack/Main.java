package com.blackjack;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.blackjack.renderer.Label;
import com.blackjack.renderer.Renderer;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Black Jack");
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		JComponent renderer = new Renderer();
		frame.getContentPane().add(renderer);
		frame.setVisible(true);

		do {
			int nbrJoueurs = 0;

			do {

				renderer.add(new Label("<html><center>Entrez le nombre de joueurs<br />(entre 1 à 4)</center></html>", 125, 50));
				renderer.repaint();
				String nJ = JOptionPane.showInputDialog(null,
						"Entrez le nombre de joueurs\n(entre 1 à 4)");

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

			for (int i = 0; i < nbrJoueurs; i++) {
				String nomJ = JOptionPane.showInputDialog(null,
						"Entrez le nom du joueur " + (i + 1));
				joueurs.add(new Joueur(nomJ));
				if (nomJ == null)
					System.exit(0);
			}

			Jeu jeu = new Jeu(joueurs);
		} while (JOptionPane.showConfirmDialog(null, "voulez-vous rejouer?") == 0);

	}

}
