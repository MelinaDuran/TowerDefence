package Objetos.comprables;

import javax.swing.ImageIcon;

import Main.Juego;
import Visitor.Visitor;

public class Barrera extends Comprable{

	public Barrera(Juego j) {
		precio=750;
		vida=500;
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Barricada/idle1.png"));
		label.setIcon(sprite);
		miJuego = j;
	}

	public void activar() {}

	public void accept(Visitor visitor) {
		visitor.visitarBarricada(this);
	}
}
