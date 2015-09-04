package com.blackjack.renderer;

import java.awt.event.ActionListener;

import javax.swing.JSlider;

public class Slider extends JSlider {
	
	public Slider(int min, int max, int posX, int posY) {
		
		this.setMinimum(min);
		this.setMaximum(max);
		this.setBounds(posX, posY, 250, 50);
		this.setMinorTickSpacing(1);
		this.setMajorTickSpacing(1);
		this.setPaintTicks(true);
		this.setPaintLabels(true);
		
	}

}
