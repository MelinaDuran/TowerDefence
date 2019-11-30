package Visitor;
import Objetos.GameObject;
import Objetos.Personajes.*;
import Objetos.comprables.Comprable;

public interface Visitor {
	
	public abstract void visitarTorre(Personaje personaje);
	public abstract void visitarEnemigo(Personaje Personaje);
	public abstract void visitarObstaculo(GameObject o);
	public abstract void visitarBarricada(Comprable personaje);
	public abstract void visitarBomba(Comprable personaje);
}
