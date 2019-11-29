package Visitor.obstaculos;
import Objetos.Personajes.Personaje;
import Visitor.*;

public class VisitorObstaculo implements Visitor{

	public void visitarTorre(Personaje personaje) {}

	public void visitarEnemigo(Personaje Personaje) {
		Personaje.setVida(0);
	}

}
