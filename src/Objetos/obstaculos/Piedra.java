package Objetos.obstaculos;

import javax.swing.ImageIcon;

import Visitor.ataque.Ataque;

public class Piedra extends Obstaculo {
	
	public Piedra() {
		
		super(100);
		
		sprite = new ImageIcon("");
		
		this.setSprite(sprite);
		
	}
}
