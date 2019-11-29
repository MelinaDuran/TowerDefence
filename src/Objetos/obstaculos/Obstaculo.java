package Objetos.obstaculos;

import Objetos.MapObject;

public abstract class Obstaculo extends MapObject{
	
	private int vida;
	
	public Obstaculo(int vida) {
		this.vida = vida;
	}
	
	public int getVida() {
		return vida;
	} 
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public void recibirAtaque(int ataque) {
		
		if(vida>ataque)
			vida-=ataque;
		else
			vida =0;
	}
	

}
