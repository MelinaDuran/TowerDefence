package Objetos.PowerUps;

import Objetos.Personajes.*;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Invulnerabilidad extends PowerUp{
	
	private ThreadInvulnerable escudo;
	
	public Invulnerabilidad() {
		miIcono = new ImageIcon("src/Main/resources/Invulnerabilidad/idle1.gif");
		miLabel = new JLabel("");
		miLabel.setIcon(miIcono);
	}
	
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
