package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.blackjack.Carte;
import com.blackjack.Hand;
import com.blackjack.Pioche;

public class HandTest {
	@Test
	public void ajoutCarte_doit_ajouter_carte_main_joueur(){
		Hand main = new Hand();
		Carte carte = new Carte(null, null);
		
		assertTrue(main.getSize() == 0);
		main.ajouterCarte(carte);
		assertTrue(main.getSize() == 1);
	}
	
	@Test
	public void retirerCarte_doit_retirer_carte_main_joueur(){
		Hand main = new Hand();
		Carte carte = new Carte(null, null);
		
		main.ajouterCarte(carte);
		main.ajouterCarte(carte);
		assertTrue(main.getSize() == 2);
		main.retirerCarte(carte);
		assertTrue(main.getSize() == 1);
	}

}
