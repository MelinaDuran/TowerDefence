package Visitor.ataque;

import Objetos.GameObject;
import Objetos.Personajes.*;
import Objetos.comprables.Comprable;

public class CuerpoACuerpo extends Ataque {
	
	public CuerpoACuerpo(Personaje personaje) {
		super(personaje);
	}
	
	public void visitarTorre(Personaje personaje) {
		//Le estoy restando la vida a una torre
		personaje.restarVida(this.getAtaque());
	}

	public void visitarEnemigo(Personaje Personaje) {
		
	}

	@Override
	public void visitarObstaculo(GameObject o) {
		// TODO Auto-generated method stub
		
	}		

	@Override
	public void visitarBomba(Comprable personaje) {
		
	}
}
