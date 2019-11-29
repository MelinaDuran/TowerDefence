package Visitor.ataque;

import Objetos.Personajes.*;

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
	
	
	

}
