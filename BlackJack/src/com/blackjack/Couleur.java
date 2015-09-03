package com.blackjack;

import java.awt.Color;

public enum Couleur {

	CARREAU(Color.red), COEUR(Color.red), PIQUE(Color.black), TREFLE(Color.black);
	
	public Color color;
	
	private Couleur(Color color ) {
		this.color = color;
	}
	
	
}

