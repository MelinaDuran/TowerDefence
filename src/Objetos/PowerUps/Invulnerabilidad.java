package Objetos.PowerUps;

import Objetos.Personajes.*;

import java.util.*;

public class Invulnerabilidad extends PowerUp{
	
	private ThreadInvulnerable escudo;
	
	public Invulnerabilidad() {}
	
	public void aplicar(List<Personaje> personajes) {
		escudo = new ThreadInvulnerable(personajes);
		escudo.activacion(true);
	}
	
	public void aplicar(Personaje personaje) {
		List<Personaje> personajes = new LinkedList<Personaje>();
		
		personajes.add(personaje);
		
		escudo = new ThreadInvulnerable(personajes);
		escudo.activacion(true);
	}

}
