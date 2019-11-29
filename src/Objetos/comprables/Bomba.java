package Objetos.comprables;

import javax.swing.ImageIcon;

public class Bomba extends Comprable {
	
	public Bomba() {
		precio = 1000;
		vida=0; //no se usa
		sprite = new ImageIcon("src/Main/resources/Comprables/Bomba/bomba.png");
		label.setIcon(sprite);
	}
	
}
