package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Carte> cartes;
	
	/**
	 * Construit une main qui sera constituée de cartes
	 */
	public Hand() {
		cartes = new ArrayList<Carte>();
	}
	
	/**
	 * Retourne la liste des cartes de la main
	 * @return la liste des cartes présentes dans la main
	 */
	public List<Carte> getCartes() {
		return cartes;
	}
	/**
	 * Pour modifier la liste des cartes
	 * @param cartes - liste à échanger 
	 */
	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	/**
	 * retire la carte du paquet
	 * @param carte - la carte à retirer du paquet 
	 */
	public void retirerCarte(Carte carte) {
		cartes.remove(carte);
	}
	/**
	 * Retourne la chaine de caractères permettant de représenter les cartes
	 */
	public String toString(){
		return cartes.toString();
	}

	/**
	 * Ajoute la carte à la main
	 * @param carte - carte à ajouter à la main
	 */
	public void ajouterCarte(Carte carte) {
		cartes.add(carte);
		
	}
	/**
	 * Permet d'obtenir le nombre de cartes composant la main 
	 * @return - un entier correspondant au nombre de cartes
	 */
	public int getSize(){
		return cartes.size();
	}
	
/**
 * Permet d'obtenir toutes les valeurs des cartes de la main
 * @return - les valeurs des cartes présentes dans la main 
 */
	public List<Valeur> getValeurs(){
		List<Valeur> val = new ArrayList<Valeur>();
		for(Carte carte : cartes)
			val.add(carte.getValeur());
		return val;
	}
}


