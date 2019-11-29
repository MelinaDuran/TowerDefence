package Objetos.comprables;

import javax.swing.ImageIcon;

public class Barrera extends Comprable{

	public Barrera() {
		precio=750;
		vida=500;
		sprite = new ImageIcon("src/Main/resources/Comprables/Barricada/idle1.png");
		label.setIcon(sprite);
	}
	
	public void recibirDanio(int ataque) {
		if(vida>ataque)
			vida = vida - ataque;
		else
			vida=0;
	}
}
