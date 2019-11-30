package Objetos.comprables;

import javax.swing.ImageIcon;

import Main.Juego;
import Visitor.ataque.Ataque;

public class Barrera extends Comprable{

	public Barrera(Juego j) {
		precio=750;
		vida=500;
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Barricada/idle1.png"));
		label.setIcon(sprite);
		miJuego = j;
		activable = false;
	}
	
	public void recibirDanio(int ataque) {
		if(vida>ataque)
			vida = vida - ataque;
		else
			vida=0;
	}

	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptar(Ataque ataque) {
		ataque.visitarBarricada(this);
	}
}
