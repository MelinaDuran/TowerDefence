package Objetos.comprables;
import Main.Juego;
import Objetos.MapObject;
import Visitor.ataque.Ataque;

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
	
	public abstract void activar();		
	
	public abstract void aceptar(Ataque a);
}
