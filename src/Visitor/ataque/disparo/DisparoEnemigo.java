package Visitor.ataque.disparo;

import Objetos.Personajes.*;

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
}