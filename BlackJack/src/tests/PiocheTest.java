package tests;

import org.junit.Assert;
import org.junit.Test;

import com.blackjack.Carte;
import com.blackjack.Couleur;
import com.blackjack.Pioche;
import com.blackjack.Valeur;

public class PiocheTest {
	@Test
	public void piocherCarte_doit_renvoyer_la_derniere_carte_du_paquet() {
		Carte cartotest = new Carte(Couleur.CARREAU, Valeur.AS);
		Pioche pioche = new Pioche();
		pioche.initPioche();
		Carte lastCarte = pioche.piocherCarte();
		Assert.assertEquals(cartotest, lastCarte);
	}
	
	
}
