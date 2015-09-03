package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Carte> cartes;
	int pts;

	public Hand() {
		cartes = new ArrayList<Carte>();
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}

	public void ajoutCarte(Pioche carte) {
		cartes.add(carte.piocherCarte());
	}

	public void retirerCarte(Carte carte) {
		cartes.remove(carte);
	}
	public String toString(){
		return cartes.toString();
	}

	public void ajouterCarte(Carte carte) {
		cartes.add(carte);
		
	}
	public int getSize(){
		return cartes.size();
	}
	

	public List<Valeur> getValeurs(){
		List<Valeur> val = new ArrayList<Valeur>();
		for(Carte carte : cartes)
			val.add(carte.getValeur());
		return val;
	}
}


