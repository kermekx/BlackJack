package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche {
	
	private List<Carte> cartes;
	
	public Pioche() {
		

		cartes = new ArrayList();
		
		for (Valeur valeur : Valeur.values())
			for (Couleur couleur : Couleur.values())
				cartes.add(new Carte(couleur, valeur));
		
		
	}
	
	private void shuffle() {
		
		Collections.shuffle(cartes);
		
	}
	
	public int getTaillePioche() {
		
		return cartes.size();

	}

}