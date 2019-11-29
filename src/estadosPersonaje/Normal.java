package estadosPersonaje;

import Objetos.Personajes.Personaje;

public class Normal extends Estado {
	
	public void restarVida(int ataque, Personaje personaje) {
		int vida = personaje.getVida();
		
		//Si tengo vida => actualizo
		if(vida>0 && vida>ataque) {
			vida = vida - ataque;
		}
		else
			//Si no, esta muerto
			vida =-1;
		
		personaje.setVida(vida);
	}
}
