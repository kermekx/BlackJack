package com.blackjack;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.blackjack.renderer.Renderer;
import com.blackjack.renderer.RenduCarte;

public class Carte {

	Couleur couleur;
	Valeur valeur;

	/**
	 * Crée une carte avec sa valeur et sa couleur
	 * 
	 * @param couleur
	 *            de la carte (Pique,Carreau,Trefle,Coeur)
	 * @param valeur
	 *            de la carte (De l'AS a ROI)
	 */
	public Carte(Couleur couleur, Valeur valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}

	/**
	 * Permet d'obtenir la couleur de la carte
	 * 
	 * @return - la couleur de la carte
	 */
	public Couleur getCouleur() {
		return couleur;
	}

	/**
	 * Retourne la valeur de la carte
	 * 
	 * @return - la valeur de la carte
	 */
	public Valeur getValeur() {
		return valeur;

	}

	/**
	 * Méthode permettant de savoir si 2 cartes sont égales, sont les mêmes
	 * 
	 * @param carte
	 *            à comparer
	 * @return true ou false selon l'équivalence
	 */
	public boolean equals(Object carte) {
		Carte toCompare = (Carte) carte;
		if (toCompare.couleur.equals(this.couleur)
				&& toCompare.valeur.equals(this.valeur)) {
			return true;
		} else
			return false;

	}

	@Override
	/**
	 * Retourne les informations de la carte : la valeur et sa couleur
	 */
	public String toString() {
		return "" + valeur + " de " + couleur;
	}
	
	public JComponent getImage(int posX, int posY) {
		
		return new RenduCarte(valeur, couleur, posX, posY);
		
	}

}
