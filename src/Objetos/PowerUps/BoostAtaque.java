package Objetos.PowerUps;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Objetos.Personajes.*;

public class BoostAtaque extends PowerUp {
	protected int ataque;
	protected int contador=0;
	protected ThreadBoostAtaque boost;
	
	public BoostAtaque()
	{
		miIcono = new ImageIcon("src/Main/resources/BoostAtaque/idle1.png");
		miLabel = new JLabel("");
		miLabel.setIcon(miIcono);
	}

	public void aplicar(List<Personaje> personajes) {
		//El ataque dura para siempre
	}
	
	public void aplicar(Personaje personaje) {		
		boost = new ThreadBoostAtaque(personaje);
		boost.activacion(true);
	}

}
