package Visitor.ataque.disparo;

import Objetos.Personajes.*;
import Objetos.comprables.Comprable;
import Objetos.obstaculos.Obstaculo;
import Visitor.Visitor;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(Personaje personaje) {
		super(personaje);
	}

	public void visitarTorre(Personaje personaje) {
		personaje.restarVida(this.getAtaque());
		this.setVida(false);
	}

	public void visitarEnemigo(Personaje personaje) {}
	
	public void visitarTorreConEscudo(Personaje personaje) {
		personaje.setVida(0);
	}

	public void visitarBarricada(Comprable comp) {
		comp.setVida(comp.getVida()-this.getAtaque());
		this.setVida(false);
	}

	public void accept(Visitor visitor) {}

	public void visitarPiedra(Obstaculo o) {
		o.setVida(this.getAtaque());
	}

	public void visitarAgujero(Obstaculo obstaculo) {}

	public void visitarBarricada(Obstaculo obstaculo) {}

	public void visitarBomba(Comprable bomba) {}

	public void visitarThwomp(Comprable thwomp) {
		thwomp.recibirDanio(this.getAtaque());
		this.setVida(false);
	}
	
	public void visitarBoostVida(Comprable boostVida) {}
}