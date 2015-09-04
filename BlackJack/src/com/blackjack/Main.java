package com.blackjack;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

import org.omg.CORBA.TypeCodePackage.Bounds;

import com.blackjack.renderer.Bouton;
import com.blackjack.renderer.Box;
import com.blackjack.renderer.Image;
import com.blackjack.renderer.Label;
import com.blackjack.renderer.Renderer;
import com.blackjack.renderer.Slider;

public class Main {

	public static boolean next = false;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Black Jack");
		frame.setSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		 JComponent renderer = new Renderer();
		frame.getContentPane().add(renderer);
		frame.setVisible(true);

		do {
			int nbrJoueurs = 0;

			JLabel label = new Label(
					"<html><center>Entrez le nombre de joueurs<br />(entre 1 à 4)</center></html>",
					275, 250);
			JSlider slider = new Slider(1, 4, 275, 300);
			JButton regles = new Bouton("Règles", 50, 500, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					JFrame regle = new JFrame("Règles du Black-Jack");
					JLabel texte = new Label("<html><ul><li>C'est un jeu qui se joue avec 52 cartes <br/><br/></li> <li>  Le nombre de joueurs est de 1 à 4 + une banque <br/><br/></li> <li> Chaque carte à sa propre valeur sauf les têtes qui valent 10 <br/><br/></li> <li> l'As peut prendre la valeur 1 ou 11, suivant le nombre de points restants<br/><br/></li> <li> Le but est de s'approcher le plus de 21 sans le dépasser <br/><br/></li> <li> La partie débute en distribuant 2 cartes à chaque joueur, la banque en reçoit 2 également après les joueurs <br/><br/></li><li> Si le score est atteint dès la distribution des cartes, il y a BlackJack </li> </ul> </html> ", 50, 50);
					regle.setPreferredSize(new Dimension(400, 400));
					regle.add(texte);
					regle.pack();
					regle.setLocationRelativeTo(null);					
					regle.setVisible(true);
					regle.repaint();
					
				}
			});
			JButton bouton = new Bouton("Valider", 350, 500,
					new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							next = true;

						}
					});
			
			JLabel image = new Image("./res/black_jack_logo.png", new Rectangle(250, 50, 300, 173));

			renderer.add(label);
			renderer.add(slider);
			renderer.add(bouton);
			renderer.add(image);
			renderer.add(regles);
			renderer.repaint();

			while (!next)
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			
			next = false;

			nbrJoueurs = slider.getValue();

			renderer.remove(label);
			renderer.remove(slider);
			renderer.remove(bouton);

			List<Joueur> joueurs = new ArrayList<Joueur>();
			List<Label> labels = new ArrayList<Label>();
			List<Box> boxs = new ArrayList<Box>();
			label = new Label(
					"<html><center>Entrez le pseudo des joueurs</center></html>",
					275, 250);

			for (int i = 0; i < nbrJoueurs; i++) {
				labels.add(new Label("<html><center>joueur " + (i + 1)
						+ " :</center></html>", (800 / nbrJoueurs) * (i), 300));
				boxs.add(new Box((800 / nbrJoueurs) * i + 50, 350));
			}
			
			bouton = new Bouton("Valider", 350, 500,
					new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							next = true;

						}
					});

			renderer.add(label);
			renderer.add(bouton);
			for (Label l : labels)
				renderer.add(l);
			for (Box b : boxs)
				renderer.add(b);

			renderer.repaint();
			
			
			while (!next)
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			
			for (Box b : boxs) {
				joueurs.add(new Joueur(b.getText()));
			}
			
			renderer.remove(label);
			renderer.remove(bouton);
			for (Label l : labels)
				renderer.remove(l);
			for (Box b : boxs)
				renderer.remove(b);
			
			renderer.repaint();

			next = false;
			
			Jeu jeu = new Jeu(joueurs, renderer);
			
		} while (JOptionPane.showConfirmDialog(null, "voulez-vous rejouer?") == 0);

	}

}
