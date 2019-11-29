package Objetos.PowerUps;
import java.util.List;
import Objetos.Personajes.*;

public class BoostAtaque extends PowerUp {
	int ataque;
	int contador=0;
	ThreadBoostAtaque boost;

	public void aplicar(List<Personaje> personajes) {
		//El ataque dura para siempre
	}
	
	public void aplicar(Personaje personaje) {		
		boost = new ThreadBoostAtaque(personaje);
		boost.activacion(true);
	}

}
