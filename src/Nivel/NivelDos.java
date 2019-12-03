package Nivel;
import Mapa.*;

public class NivelDos extends Nivel {
	public NivelDos(Mapa m) {
		super(m);
		cantEnemigos = 11;
		nroNivel = 2;
		crearEnemigos();
		crearObstaculos(2);
		System.out.println("NIVEL DOS");
	}
	
	public Nivel pasarDeNivel(Mapa mapa) {
		obstaculos.clear();
		return new NivelTres(mapa);
	}
}
