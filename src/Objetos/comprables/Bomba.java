package Objetos.comprables;

import javax.swing.ImageIcon;

import Main.Juego;
import Objetos.GameObject;
import Objetos.Personajes.Personaje;
import Visitor.ataque.Ataque;

public class Bomba extends Comprable {
	
	public Bomba(Juego j) {
		precio = 1000;
		vida=20; //no se usa
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Bomba/bomba.png"));
		label.setIcon(sprite);
		miJuego = j;
		activable = true;
	}

	@Override
	public void activar() {
		if (celda.getPersonaje() != null)
			celda.getPersonaje().setVida(0);
		
	}

	@Override
	public void aceptar(Ataque ataque) {
		ataque.visitarBomba(this);
	}	
}
