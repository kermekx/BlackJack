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

	public void ajoutCarte(Carte carte) {
		cartes.add(carte);
	}

	public void retirerCarte(Carte carte) {
		cartes.remove(carte);
	}
	public String toString(){
		String res="";
		for(int i=0; i<cartes.size()-1;i++){
			res=res+cartes.get(i)+"\n";
		}
		return res;
	}
	
}
