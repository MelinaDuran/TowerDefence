package Objetos.Personajes.torres;

import Mapa.*;
import Objetos.GameObject;
import Objetos.Personajes.Personaje;
import Visitor.ataque.*;
import Visitor.ataque.disparo.Disparo;

public abstract class Torre extends Personaje{
	
	protected int precio;
	private Celda celda;
	
	
	
	public Torre() {
		super();
	}
	
	public int getPrecio(){
		return precio;
	}
		
	public void setPrecio(int precio){
		this.precio = precio;
	}
		
	public Celda getCelda() {
		return celda;
	}
	
	public void setCelda(Celda celda) {
		this.celda=celda;
	}
	
	public Disparo atacar() {
		return estado.disparar(this);
	}
	
	public void aceptar(GameObject p) {}
	
	public void accept(Ataque ataque) {
		ataque.visitarTorre(this);
	}
}
