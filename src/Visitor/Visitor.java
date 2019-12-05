package Visitor;
import Objetos.Personajes.*;
import Objetos.Personajes.enemigos.Enemigo;
import Objetos.Personajes.torres.Torre;
import Objetos.obstaculos.Agujero;
import Objetos.obstaculos.Obstaculo;
import Objetos.obstaculos.Piedra;
import Objetos.comprables.*;

public interface Visitor {
	
	public abstract void visitarTorre(Torre personaje);
	public abstract void visitarEnemigo(Enemigo Personaje);
	public abstract void visitarPiedra(Piedra obstaculo); 
	public abstract void visitarAgujero(Agujero obstaculo);
	public abstract void visitarBarricada(Barrera obstaculo);
	public abstract void visitarBomba(Bomba bomba);
	public abstract void visitarThwomp (Thwomp thwomp);
	public abstract void visitarBoostVida(BoostVida boostVida);
}
