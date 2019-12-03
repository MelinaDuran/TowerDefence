package Visitor;
import Objetos.Personajes.*;
import Objetos.obstaculos.Obstaculo;
import Objetos.comprables.*;

public interface Visitor {
	
	public abstract void visitarTorre(Personaje personaje);
	public abstract void visitarEnemigo(Personaje Personaje);
	public abstract void visitarPiedra(Obstaculo obstaculo); 
	public abstract void visitarAgujero(Obstaculo obstaculo);
	public abstract void visitarBarricada(Comprable obstaculo);
	public abstract void visitarBomba(Comprable bomba);
	public abstract void visitarThwomp(Comprable thwomp);
	public abstract void visitarBoostVida(Comprable boostVida);
}
