package com.blackjack;

public class Carte {
	
	Couleur couleur;
	Valeur valeur;
	public Carte (Couleur couleur, Valeur valeur){
		this.couleur = couleur;
		this.valeur=valeur;
	}
	
	/**
	 * Permet d'obtenir la couleur de la carte
	 * @return	- la couleur de la carte
	 */
	public Couleur getCouleur(){
		return couleur;
	}
	
	/**
	 * Retourne la valeur de la carte
	 * @return - la valeur de la carte
	 */
	public Valeur getValeur(){
		return valeur;
		
	}
	
	/**
	 * Méthode permettant de savoir si 2 cartes sont égales, sont les mêmes
	 * @param carte à comparer 
	 * @return true ou false selon l'équivalence
	 */
public boolean equals(Carte carte){
	if(carte.couleur.equals(this.couleur) && carte.valeur.equals(this.valeur)){
		return true;
	}
	else return false;

	
}
	@Override
	/**
	 * Retourne les informations de la carte : la valeur et sa couleur
	 */
	public String toString() {
		return ""+ valeur +" de "+couleur;
	}
	
	
}
