package Nivel;
import Mapa.*;

public class NivelUno extends Nivel {
	public NivelUno(Mapa m) {
		super(m);
		cantEnemigos=6;
		nroNivel = 1;
		crearEnemigos();
	}
	
	public Nivel pasarDeNivel(Mapa mapa) {
		return new NivelDos(mapa);
	}
}
