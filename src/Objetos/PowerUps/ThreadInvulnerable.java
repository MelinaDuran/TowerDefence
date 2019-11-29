package Objetos.PowerUps;
import java.util.*;
import estadosPersonaje.*;
import Objetos.Personajes.*;

public class ThreadInvulnerable extends Thread {

	private boolean activado;
	private List<Personaje> personajes;
	
	public ThreadInvulnerable(List<Personaje> personajes) {
		activado = false;
		this.personajes = personajes;
	}
	
	public void run() {
		while(activado) {
			try {
				
				for(Personaje e : personajes) {
					e.setEstado(new Invulnerable());
				}
					
				sleep(10000);
				
				for(Personaje e : personajes) {
					
					e.setEstado(new Normal());
				}
				
				
				activado = false;
			
			}catch(Exception e) {e.printStackTrace();}
		}		
	}
	
	public void activacion(boolean a) {
		activado = a;
	}
	
	
}
