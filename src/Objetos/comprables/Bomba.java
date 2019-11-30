package Objetos.comprables;

import javax.swing.ImageIcon;

import Main.Juego;
import Visitor.ataque.Ataque;

public class Bomba extends Comprable {
	
	public Bomba(Juego j) {
		precio = 1000;
		vida=0; //no se usa
		sprite = new ImageIcon("src/Main/resources/Comprables/Bomba/bomba.png");
		label.setIcon(sprite);
		miJuego = j;
	}

	@Override
	public void activar() {
		if (celda.getPersonaje() != null)
			celda.getPersonaje().setVida(0);
		
	}

	@Override
	public void aceptar(Ataque ataque) {
		// TODO Auto-generated method stub
		
	}
	
}
