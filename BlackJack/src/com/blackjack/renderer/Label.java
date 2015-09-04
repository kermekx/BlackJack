package com.blackjack.renderer;

import javax.swing.JLabel;

public class Label extends JLabel {
	
	public Label(String text, int posX, int posY) {
		
		this.setText(text);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBounds(posX, posY, 250, 50);
		
	}

}
