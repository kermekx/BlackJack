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
