package com.blackjack.renderer;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Renderer extends JComponent {
	
		public Renderer() {
			
			this.setSize(new Dimension(800, 600));
			
		}
	
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
		}

}
