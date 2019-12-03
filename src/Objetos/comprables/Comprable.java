package Objetos.comprables;
import Main.Juego;
import Objetos.MapObject;

public abstract class Comprable extends MapObject {

	protected int precio; 
	protected int vida;
	protected Juego miJuego;
	
	public int getPrecio() {
		return precio;
	}
	
	public void serPrecio(int p) {
		precio=p;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int v) {
		vida=v; 
	}
	
	public void recibirDanio(int ataque) {
		if(vida>ataque)
			vida = vida - ataque;
		else
			vida=0;
	}
}
