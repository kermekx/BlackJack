package com.blackjack;

import java.util.List;

public enum Valeur {

	AS(1), DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8), NEUF(
			9), DIX(10), VALET(10), DAME(10), ROI(10);

	/**
	 * valeurs des cartes (l'as peu valoire 1 ou 11)
	 */
	private int points;

	/**
	 * créé l'enumeration des valeurs
	 * 
	 * @param points
	 *            des valeurs
	 */
	private Valeur(int points) {

		this.points = points;

	}

	/**
	 * calcule le nombre de points optimale d'une liste de valeur en choisisant
	 * 1 ou 11 pour les as de la meilleur facon possible
	 * 
	 * @param liste
	 *            de valeur de la main
	 * @return valeur de la main
	 */
	public static int getPoints(List<Valeur> valeurs) {

		int nbrAs = 0;
		int points = 0;

		for (Valeur valeur : valeurs) {
			points += valeur.points;
			if (valeur == AS)
				nbrAs++;
		}

		while (nbrAs > 0) {
			if (points <= 11)
				points += 10;

			nbrAs--;
		}

		return points;

	}

}
