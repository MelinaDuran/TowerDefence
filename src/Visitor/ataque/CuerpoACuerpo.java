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
		System.out.println("LE PEGUE "+this.getAtaque()+" "+personaje.getVida());
	}

	public void visitarEnemigo(Personaje Personaje) {
		
	}

	@Override
	public void visitarObstaculo(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBarricada(Comprable personaje) {
		personaje.setVida(personaje.getVida() - this.getAtaque());
	}

	@Override
	public void visitarBomba(Comprable personaje) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
