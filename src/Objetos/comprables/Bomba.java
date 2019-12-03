package Objetos.comprables;

import javax.swing.ImageIcon;

import Main.Juego;
import Visitor.Visitor;

public class Bomba extends Comprable {
	
	public Bomba(Juego j) {
		precio = 1000;
		vida=20;
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Bomba/bomba.png"));
		label.setIcon(sprite);
		miJuego = j;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitarBomba(this);
	}

	
}
