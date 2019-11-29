package Visitor.ataque.disparo;

import Objetos.Personajes.*;

public class DisparoTorre extends Disparo {

	public DisparoTorre(Personaje personaje) {
		super(personaje);
	}
	
	public void visitarTorre(Personaje personaje) {	}

	//Se encarga de la acci�n que produce un disparo en el ENEMIGO
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
	
}