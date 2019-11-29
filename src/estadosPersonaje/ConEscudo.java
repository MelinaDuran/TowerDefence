package estadosPersonaje;

import Objetos.Personajes.*;

public class ConEscudo extends Estado{
	
	public ConEscudo() {}

	public void restarVida(int ataque, Personaje personaje) {
		personaje.setEstado(new Normal());
	}
	
	/*
	public Disparo disparar(Personaje personaje) {
		return new DiasparoEspecial(personaje);
	}
	*/
}
