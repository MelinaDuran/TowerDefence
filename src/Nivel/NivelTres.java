package Nivel;

import Mapa.Mapa;

public class NivelTres extends Nivel {
	public NivelTres(Mapa m) {
		super(m);
		cantEnemigos = 15;
		crearEnemigos();
		nroNivel = 3;
		System.out.println("NIVEL TRES");
	}
	
	public Nivel pasarDeNivel(Mapa mapa) {
		return null;
	}
}
