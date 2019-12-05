package Visitor.ataque;

import Objetos.Personajes.*;
import Objetos.Personajes.enemigos.Enemigo;
import Objetos.Personajes.torres.Torre;
import Objetos.obstaculos.Agujero;
import Objetos.obstaculos.Obstaculo;
import Objetos.obstaculos.Piedra;
import Visitor.Visitor;
import Objetos.comprables.*;

public class CuerpoACuerpo extends Ataque {
	
	
	public CuerpoACuerpo(Personaje personaje) {
		super(personaje);
	}
	
	public void visitarTorre(Torre personaje) {
		personaje.restarVida(this.getAtaque());
	}

	public void visitarEnemigo(Enemigo Personaje) {}
	
	public void visitarBomba(Bomba bomba) {
		this.getPersonaje().setVida(0);
		bomba.setVida(0);
	}

	public void visitarPiedra(Piedra obstaculo) {
		obstaculo.setVida(this.getAtaque());
	}

	public void visitarAgujero(Agujero obstaculo) {
		this.getPersonaje().setVida(0);
		obstaculo.setVida(0);
	}
		
	public void accept(Visitor visitor) {}

	public void visitarBarricada(Barrera barrera) {
		barrera.recibirDanio(this.getAtaque());
	}
	
	public void visitarThwomp(Thwomp thwomp) {
		thwomp.recibirDanio(this.getAtaque());
	}
	
	public void visitarBoostVida(BoostVida boostVida) {}
	
}
