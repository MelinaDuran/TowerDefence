package Nivel;
import Factory.*;
import Mapa.*;
import Objetos.Personajes.enemigos.Enemigo;

import Objetos.obstaculos.*;

import java.util.*;

public abstract class Nivel  {

	protected Mapa mapa;
	protected int cantEnemigos;
	private LinkedList<Enemigo> enemigos;
	private Random random;
	protected FabricaEnemigo fEnemigos;
	protected int nroNivel;
	
	protected List<Obstaculo> obstaculos;
	
	
	public Nivel(Mapa m) {
		mapa=m;
		random = new Random();
		enemigos = new LinkedList<Enemigo>();
		obstaculos = new LinkedList<Obstaculo>();
	}
	
	public void crearEnemigos(){
		int rdm = random.nextInt(6); 
		System.out.println("CREANDO LOS ENEMIGOS");
		for (int i=0; i<cantEnemigos; i++) {
			FabricaEnemigo fabrica;
			
			switch(rdm) {
				case 0:
					fabrica = FabricaEnemigoBadnik.getFabricaEnemigoBadnik(); 
					break;
				case 1:
					fabrica = FabricaEnemigoDarkMan.getFabricaEnemigoDarkMan(); 
					break;
				case 2:
					fabrica = FabricaEnemigoFantasma.getFabricaEnemigoFantasma(); 
					break;
				case 3:
					fabrica = FabricaEnemigoGoomba.getFabricaEnemigoGoomba(); 
					break;
				case 4:
					fabrica = FabricaEnemigoLongMoan.getFabricaEnemigoLongMoan(); 
					break;
				case 5:
					fabrica = FabricaEnemigoOctorok.getFabricaEnemigoOctorok();
					break;
				default:
					fabrica = FabricaEnemigoStalfos.getFabricaEnemigoStalfos();
			}
			enemigos.add(fabrica.crearEnemigo());
			rdm = random.nextInt(6);
		}
	}
	
	
	public void crearObstaculos(int cantidad) {
		//ACA TENES QUE HACER ESTO PARA AGREGAR A LOS OBSTACULOS MELINASTI
		int rdm = random.nextInt(2);
		int rdmI;
		int rdmJ;
		Obstaculo o;
		while(obstaculos.size()<cantidad) {
			if(rdm==0)	
			{
				o = new Agujero();
				System.out.println("CREADO AGUJERO");
			}
			else
			{
				o = new Piedra();
				System.out.println("CREADA PIEDRA");
			}
			
			rdmJ = random.nextInt(10);
			rdmI = random.nextInt(6);
			o.setCelda(mapa.getCelda(rdmI, rdmJ));
			obstaculos.add(o);
			rdm = random.nextInt(1);
		}
		
	}
	
	public Enemigo getNextEnemigo(){
		if (enemigos.isEmpty()) 
			return null;
		
		return enemigos.remove(0);
	}
	
	public boolean noHayMasEnemigos() {
		return enemigos.isEmpty();
	}
	
	
	//Retorna la lista de enemigos correspondiente al nivel
	public LinkedList<Enemigo> getEnemigos(){
		return enemigos;
		
	}
	
	public List<Obstaculo> getObstaculos(){
		return obstaculos;
	}
	
	public abstract Nivel pasarDeNivel(Mapa mapa);
	
	public int getNroNivel() {return nroNivel;}
	
	public void setNroNivel(int i) {nroNivel = i;}
}
