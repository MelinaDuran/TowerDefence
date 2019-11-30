package Objetos.obstaculos;

import javax.swing.ImageIcon;

public class Agujero extends Obstaculo{

	public Agujero() {
		
		super(100);
		
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/obstaculos/agujero.png"));
		
		this.setSprite(sprite);
		
	}
}
