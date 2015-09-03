package tests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.blackjack.Carte;
import com.blackjack.Couleur;
import com.blackjack.Hand;
import com.blackjack.Pioche;
import com.blackjack.Valeur;

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
		
		Carte carte1 = new Carte(Couleur.COEUR,Valeur.CINQ);
		main.ajouterCarte(carte1);
		
		assertTrue(main.getSize() == 1);
		main.retirerCarte(carte1);
		assertTrue(main.getSize() == 0);
	}
	
	@Test
	public void getValeur_doit_retourner_les_valeurs_des_cartes_de_la_main(){
		Hand main = new Hand();
		main.ajouterCarte(new Carte(Couleur.CARREAU,Valeur.NEUF));
		main.ajouterCarte(new Carte(Couleur.CARREAU,Valeur.SIX));
		main.ajouterCarte(new Carte(Couleur.PIQUE,Valeur.DIX));
		List<Valeur> lesValeurs = main.getValeurs();
		assertEquals(3, lesValeurs.size());
		assertTrue(lesValeurs.contains(Valeur.NEUF));
	}

}
