package Objetos.obstaculos;

import javax.swing.ImageIcon;

public class Agujero extends Obstaculo{

	public Agujero() {
		
		super(100);
		
		sprite = new ImageIcon("src/main/resources/obstaculos/agujero.png");
		
		this.setSprite(sprite);
		
	}
	
}
