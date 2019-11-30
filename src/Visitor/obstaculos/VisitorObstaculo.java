package Visitor.obstaculos;
import Objetos.GameObject;
import Objetos.Personajes.Personaje;
import Objetos.comprables.Comprable;
import Visitor.*;

public class VisitorObstaculo implements Visitor{

	public void visitarTorre(Personaje personaje) {}

	public void visitarEnemigo(Personaje Personaje) {
		Personaje.setVida(0);
	}

	@Override
	public void visitarObstaculo(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBarricada(Comprable personaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBomba(Comprable personaje) {
		// TODO Auto-generated method stub
		
	}

}
