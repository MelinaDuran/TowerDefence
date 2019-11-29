package Visitor;
import Objetos.Personajes.*;

public interface Visitor {
	
	public abstract void visitarTorre(Personaje personaje);
	public abstract void visitarEnemigo(Personaje Personaje);
	
	
}
