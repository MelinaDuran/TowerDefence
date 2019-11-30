package Visitor.ataque.disparo;

import Objetos.GameObject;
import Objetos.Personajes.*;
import Objetos.comprables.Comprable;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(Personaje personaje) {
		super(personaje);
	}

	//Si visitar a una torre entonces afecta a la vida del personaje
	public void visitarTorre(Personaje personaje) {
		personaje.restarVida(this.getAtaque());
		this.setVida(false);
	}

	
	public void visitarEnemigo(Personaje personaje) {
		
	}
	
	
	//Si se choca contra un escudo => Muere
	public void visitarTorreConEscudo(Personaje personaje) {
		personaje.setVida(0);
	}

	@Override
	public void visitarObstaculo(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBarricada(Comprable comp) {
		comp.setVida(comp.getVida()-this.getAtaque());
		this.setVida(false);
	}

	@Override
	public void visitarBomba(Comprable personaje) {
		
	}
}