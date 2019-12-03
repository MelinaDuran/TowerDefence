package Objetos.obstaculos;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class Piedra extends Obstaculo {
	
	public Piedra() {
		
		super(100);
		
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/obstaculos/piedra.png"));
		this.setSprite(sprite);
		label.setIcon(sprite);
		
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitarPiedra(this);
	}
}
