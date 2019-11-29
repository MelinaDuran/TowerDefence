package Objetos;
import Objetos.GameObject;

public abstract class MapObject extends GameObject{
	protected static final int t = 10000;
	protected int tiempoEnMapa = t;
	
	public void reducirTiempoEnMapa(){tiempoEnMapa--;}
}
