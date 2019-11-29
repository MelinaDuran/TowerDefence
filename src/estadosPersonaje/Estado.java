package estadosPersonaje;

import Objetos.Personajes.*;
import Visitor.ataque.disparo.Disparo;
import Visitor.ataque.disparo.DisparoTorre;

public abstract class Estado {
	
	public abstract void restarVida(int ataque,Personaje personaje);

	
	public Disparo disparar(Personaje personaje) {
		return new DisparoTorre(personaje);
	}
}
