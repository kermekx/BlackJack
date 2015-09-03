package com.blackjack;

public class Carte {
	
	Couleur couleur;
	Valeur valeur;
	public Carte (Couleur couleur, Valeur valeur){
		this.couleur = couleur;
		this.valeur=valeur;
	}
	
	public Couleur getCouleur(){
		return couleur;
	}
	
	public Valeur getValeur(){
		return valeur;
		
	}
	
public boolean equals(Carte carte){
	if(carte.couleur.equals(this.couleur) && carte.valeur.equals(this.valeur)){
		return true;
	}
	else return false;

	
}
	@Override
	public String toString() {
		return "Carte [couleur=" + couleur + ", valeur=" + valeur + "]";
	}
	
	
}
