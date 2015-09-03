package com.blackjack;

import java.awt.Color;

public enum Couleur {

	CARREAU(Color.red), COEUR(Color.red), PIQUE(Color.black), TREFLE(
			Color.black);
	/**
	 * Couleurs des signes
	 */
	public Color color;

	/**
	 * Crée l'énumération des couleurs
	 * 
	 * @param color
	 *            - couleur du signe
	 */
	private Couleur(Color color) {
		this.color = color;
	}

}
