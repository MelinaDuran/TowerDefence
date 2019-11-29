package Objetos.PowerUps;

import Objetos.Personajes.Personaje;

public class ThreadBoostAtaque extends Thread {
	private boolean activado; 
	private Personaje p;
	public ThreadBoostAtaque(Personaje personaje) {
		activado=false; 
		p=personaje;
	}
	public void run() {
		while(activado) {
			try {
				p.setAtaque(p.getAtaque()+100);
				sleep(10000);		
				p.setAtaque(p.getAtaque()-100);
				activado = false;
			
			}catch(Exception e) {e.printStackTrace();}
		}		
	}
	
	public void activacion(boolean a) {
		activado = a;
	}
}
