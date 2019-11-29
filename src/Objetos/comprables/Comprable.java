package Objetos.comprables;
import Objetos.MapObject;

public abstract class Comprable extends MapObject {

	protected int precio; 
	protected int vida;
	
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
}
