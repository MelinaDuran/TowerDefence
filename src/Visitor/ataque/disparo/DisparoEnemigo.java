package Visitor.ataque.disparo;

import Objetos.Personajes.*;
import Objetos.Personajes.enemigos.Enemigo;
import Objetos.Personajes.torres.Torre;
import Objetos.comprables.Barrera;
import Objetos.comprables.Bomba;
import Objetos.comprables.BoostVida;
import Objetos.comprables.Comprable;
import Objetos.comprables.Thwomp;
import Objetos.obstaculos.Agujero;
import Objetos.obstaculos.Obstaculo;
import Objetos.obstaculos.Piedra;
import Visitor.Visitor;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(Personaje personaje) {
		super(personaje);
	}

	public void visitarTorre(Torre personaje) {
		personaje.restarVida(this.getAtaque());
		this.setVida(false);
	}

	public void visitarEnemigo(Enemigo personaje) {}
	
	public void visitarTorreConEscudo(Torre personaje) {
		personaje.setVida(0);
	}

	public void visitarBarricada(Barrera comp) {
		comp.setVida(comp.getVida()-this.getAtaque());
		this.setVida(false);
	}

	public void accept(Visitor visitor) {}

	public void visitarPiedra(Piedra o) {
		o.setVida(this.getAtaque());
	}

	public void visitarAgujero(Agujero obstaculo) {}

	//public void visitarBarricada(Barrera obstaculo) {}

	public void visitarBomba(Bomba bomba) {}

	public void visitarThwomp(Thwomp thwomp) {
		thwomp.recibirDanio(this.getAtaque());
		this.setVida(false);
	}
	

	@Override
	public void visitarBoostVida(BoostVida boostVida) {
		// TODO Auto-generated method stub
		
	}
}