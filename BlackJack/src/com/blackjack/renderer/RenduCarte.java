package com.blackjack.renderer;

import java.awt.Rectangle;

import javax.swing.JComponent;

import com.blackjack.Couleur;
import com.blackjack.Valeur;

public class RenduCarte extends JComponent {

	public RenduCarte(Valeur valeur, Couleur couleur, int posX, int posY) {

		this.setBounds(posX, posY, 66, 103);
		this.add(new Image("res/" + valeur + "_" + couleur + ".png",
				new Rectangle(0, 0, 66, 103)));

	}

}
