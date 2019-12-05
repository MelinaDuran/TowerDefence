package Visitor.ataque.disparo;

import Objetos.Personajes.*;
import Objetos.Personajes.enemigos.Enemigo;
import Objetos.Personajes.torres.Torre;
import Objetos.obstaculos.Agujero;
import Objetos.obstaculos.Obstaculo;
import Objetos.obstaculos.Piedra;
import Visitor.Visitor;
import Objetos.comprables.*;

public class DisparoTorre extends Disparo {

	public DisparoTorre(Personaje personaje) {
		super(personaje);
	}
	
	public void visitarTorre(Torre personaje) {	}

	public void visitarEnemigo(Enemigo personaje) {
		personaje.restarVida(this.getAtaque());
		System.out.println("VIDA DEL ENEMIGO: "+personaje.getVida());
		this.setVida(false);
	}
	
	public void visitarEnemigoConEscudo(Personaje personaje) {
		personaje.setVida(0);
		this.setVida(false);
	}
	
	public void visitarBoostVida(BoostVida boostVida) {}

	public void accept(Visitor visitor) {}

	public void visitarPiedra(Piedra o) {}

	public void visitarAgujero(Agujero obstaculo) {}

	public void visitarBarricada(Barrera obstaculo) {}

	public void visitarBomba(Bomba bomba) {}

	public void visitarThwomp(Thwomp thwomp) {}
	
	

}