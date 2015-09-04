package com.blackjack.renderer;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Bouton extends JButton {
	
	public Bouton(String text, int posX, int posY, ActionListener al) {
		
		this.setText(text);
		this.setBounds(posX, posY, 100, 25);
		this.addActionListener(al);
		
	}

}
