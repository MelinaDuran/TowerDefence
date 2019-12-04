package Visitor.ataque;

import Objetos.Personajes.*;
import Objetos.obstaculos.Obstaculo;
import Visitor.Visitor;
import Objetos.comprables.*;

public class CuerpoACuerpo extends Ataque {
	
	
	public CuerpoACuerpo(Personaje personaje) {
		super(personaje);
	}
	
	public void visitarTorre(Personaje personaje) {
		personaje.restarVida(this.getAtaque());
	}

	public void visitarEnemigo(Personaje Personaje) {}
	
	public void visitarBomba(Comprable bomba) {
		this.getPersonaje().setVida(0);
		bomba.setVida(0);
	}

	public void visitarPiedra(Obstaculo obstaculo) {
		obstaculo.setVida(this.getAtaque());
	}

	public void visitarAgujero(Obstaculo obstaculo) {
		this.getPersonaje().setVida(0);
		obstaculo.setVida(0);
	}
		
	public void accept(Visitor visitor) {}

	public void visitarBarricada(Comprable barrera) {
		barrera.recibirDanio(this.getAtaque());
	}
	
	public void visitarThwomp(Comprable thwomp) {
		thwomp.recibirDanio(this.getAtaque());
	}
	
	public void visitarBoostVida(Comprable boostVida) {}
	
}
