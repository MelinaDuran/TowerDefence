package Objetos.PowerUps;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Objetos.Personajes.*;
import estadosPersonaje.*;

public class Escudo extends PowerUp {
	
	public Escudo(){
		miIcono = new ImageIcon(this.getClass().getResource("/Main/resources/Escudo/idle1.gif"));
		miLabel = new JLabel("");
		miLabel.setIcon(miIcono);
	}
	
	public void aplicar(Personaje personaje) {
		
		personaje.setEstado(new ConEscudo());
		System.out.println("tiene escudito");
	}
	
	public void aplicar(List<Personaje> personajes) {
			
		for(Personaje personaje : personajes) {
			personaje.setEstado(new ConEscudo());
		}
	}

}
