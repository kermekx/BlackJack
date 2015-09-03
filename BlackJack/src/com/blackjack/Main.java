package com.blackjack;


public class Main {
	
	public static void main(String[] args) {
		
		Pioche pioche = new Pioche();
		System.out.println(pioche);
		
		System.out.println(pioche.getTaillePioche());
		System.out.println(pioche.piocherCarte());
		System.out.println(pioche.getTaillePioche());
		
	}

}
