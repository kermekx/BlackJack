package com.blackjack.renderer;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Image extends JLabel {
	
	public Image(String url, Rectangle bounds) {

		this.setIcon(new ImageIcon(url));
		this.setBounds(bounds);
		
	}

}
