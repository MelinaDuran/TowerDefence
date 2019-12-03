package Visitor.ataque.disparo;

import Objetos.Personajes.*;
import Objetos.obstaculos.Obstaculo;
import Visitor.Visitor;
import Objetos.comprables.*;

public class DisparoTorre extends Disparo {

	public DisparoTorre(Personaje personaje) {
		super(personaje);
	}
	
	public void visitarTorre(Personaje personaje) {	}

	public void visitarEnemigo(Personaje personaje) {
		personaje.restarVida(this.getAtaque());
		System.out.println("VIDA DEL ENEMIGO: "+personaje.getVida());
		this.setVida(false);
	}
	
	public void visitarEnemigoConEscudo(Personaje personaje) {
		personaje.setVida(0);
		this.setVida(false);
	}

	public void accept(Visitor visitor) {}

	public void visitarPiedra(Obstaculo o) {}

	public void visitarAgujero(Obstaculo obstaculo) {}

	public void visitarBarricada(Obstaculo obstaculo) {}

	public void visitarBomba(Comprable bomba) {}

	public void visitarThwomp(Comprable thwomp) {}
	
	

}