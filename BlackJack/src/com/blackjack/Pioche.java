package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche {
	
	private List<Carte> cartes;

	/**
	 * génère un paquet de 52 cartes aléatoires sans doublons
	 */
	public Pioche() {

		cartes = new ArrayList();

		initPioche();

		this.shuffle();

	}

	/**
	 * initialise le paquet avec toutes les cartes de chaques couleurs et
	 * valeurs différentes
	 */
	public void initPioche() {
		cartes.clear();
		for (Valeur valeur : Valeur.values())
			for (Couleur couleur : Couleur.values())
				cartes.add(new Carte(couleur, valeur));
	}

	/**
	 * mélange le paquet de carte
	 */
	private void shuffle() {

		Collections.shuffle(cartes);

	}

	/**
	 * Retourne la taille de la pioche
	 * 
	 * @return un entier qui correspond à la taille de la pioche
	 */
	public int getTaillePioche() {

		return cartes.size();

	}

	/**
	 * pioche une carte du paquet
	 * 
	 * @return la dernière carte du paquet
	 */
	public Carte piocherCarte() {

		Carte carte = cartes.get(0);
		cartes.remove(0);
		return carte;

	}

	@Override
	public String toString() {
		return "Pioche [cartes=" + cartes + "]";
	}

}
