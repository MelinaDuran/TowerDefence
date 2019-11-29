package Objetos.PowerUps;

import java.util.*;
import Objetos.Personajes.*;
import estadosPersonaje.*;

public class Escudo extends PowerUp {
	
	
	public void aplicar(Personaje personaje) {
		
		personaje.setEstado(new ConEscudo());
		
	}
	
	public void aplicar(List<Personaje> personajes) {
		
		
		for(Personaje personaje : personajes) {
			personaje.setEstado(new ConEscudo());
		}
	
	}

}
