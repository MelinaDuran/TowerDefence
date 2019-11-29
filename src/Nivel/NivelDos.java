package Nivel;
import Mapa.*;

public class NivelDos extends Nivel {
	public NivelDos(Mapa m) {
		super(m);
		cantEnemigos = 11;
		crearEnemigos();
		nroNivel = 2;
		System.out.println("NIVEL DOS");
	}
	
	public Nivel pasarDeNivel(Mapa mapa) {
		return new NivelTres(mapa);
	}
}
