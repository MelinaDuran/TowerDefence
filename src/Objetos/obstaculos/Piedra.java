package Objetos.obstaculos;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class Piedra extends Obstaculo {
	
	public Piedra() {
		
		super(100);
		
		sprite = new ImageIcon("");
		
		this.setSprite(sprite);
		
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitarPiedra(this);
	}
}
