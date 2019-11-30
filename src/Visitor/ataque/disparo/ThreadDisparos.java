package Visitor.ataque.disparo;


import Main.Juego;
import Objetos.Personajes.*;
import Objetos.Personajes.enemigos.Enemigo;

import java.util.*;

public class ThreadDisparos extends Thread {
	private Juego juego;
	private Random random;
	
	private boolean parar;
	
	
	public ThreadDisparos(Juego juego) {
		this.juego = juego;
		parar = true;
		random = new Random();
	}
	
	public void reiniciar() {
		
		this.parar = false;
		
	}
	
	public void run() {
		
		while(parar && juego.getEstado()){
			
			try {
				
				Thread.sleep(200);
				
				int rdm = random.nextInt(6);
				
				List<Personaje> personajes = juego.getTorres();
				List<Enemigo> enemigos = juego.getEnemigos();
				
				if(rdm % 2 ==0 && juego.getEnemigos().size()!=0) {
					
					for(Personaje personaje : personajes) {
						juego.agregarDisparo(personaje.atacar());
					}
					for(Enemigo enemigo : enemigos) {
						juego.agregarDisparoEnemigo(enemigo.atacar());
					}
					
					rdm = random.nextInt(6);
				}
				juego.moverDisparos();
				juego.moverDisparosEnemigos();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
