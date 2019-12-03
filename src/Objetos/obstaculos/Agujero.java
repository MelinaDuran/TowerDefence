package Objetos.obstaculos;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class Agujero extends Obstaculo{

	public Agujero() {
		
		super(100);
		
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/obstaculos/agujero.png"));
		label.setIcon(sprite);
		
		this.setSprite(sprite);
		
	}

	public void accept(Visitor visitor) {
		
	}
	
}
