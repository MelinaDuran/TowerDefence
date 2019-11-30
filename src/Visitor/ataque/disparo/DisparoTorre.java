package Visitor.ataque.disparo;

import Objetos.GameObject;
import Objetos.Personajes.*;
import Objetos.comprables.Comprable;

public class DisparoTorre extends Disparo {

	public DisparoTorre(Personaje personaje) {
		super(personaje);
	}
	
	public void visitarTorre(Personaje personaje) {	}

	//Se encarga de la acción que produce un disparo en el ENEMIGO
	public void visitarEnemigo(Personaje personaje) {

		//LE RESTO VIDA => LOS CONTROLES DE SI ES POSIBLE SE REALIZAN EN RESTARVIDA()
		personaje.restarVida(this.getAtaque());
		System.out.println("VIDA DEL ENEMIGO: "+personaje.getVida());
		this.setVida(false); //al parecer no estaria seteandolo bien
		
	}
	
	public void visitarEnemigoConEscudo(Personaje personaje) {
		personaje.setVida(0);
		this.setVida(false);
	}

	@Override
	public void visitarObstaculo(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBarricada(Comprable personaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBomba(Comprable personaje) {
		// TODO Auto-generated method stub
		
	}	
}