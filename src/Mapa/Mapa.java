package Mapa;

import Objetos.Personajes.enemigos.Enemigo;
import Objetos.Personajes.torres.Torre;
import Objetos.comprables.Comprable;

import java.util.Random;
import Objetos.obstaculos.*;


public class Mapa {
	
  private  Celda [][] mapa;
  private Random rdm;

 
  public Mapa() {
	  generarMapa();
	  rdm = new Random();
  }
  
  public void generarMapa() {
	  mapa = new Celda[6][10];
	  
	  for(int i=0;i<mapa.length;i++) {
		  for(int j=0;j<mapa[0].length;j++) {
			mapa[i][j]= new Celda(i,j);
		}
	  }
  }
  
  public Celda getCelda(int x, int y) {
	  return mapa[x][y];
  }
  
  public void agregarEnemigo(Enemigo e) {
	 int random = rdm.nextInt(6);
	 mapa[random][9].addPersonaje(e);
	 e.setCelda(mapa[random][9]);	  
  }
  
  public void agregarPersonaje(Torre t, int fila, int columna) {
	  Celda celda = mapa[fila][columna];
	  //System.out.println("Celda: "+fila+", "+ columna);
	  if (celda.isEmpty()) {
		celda.addPersonaje(t);
	  	t.setCelda(celda);
	  	
	  	if (t.getTamanio() == 2)
	  	{
	  		Celda arriba = celdaArriba(celda);
	  		t.setCeldaSecundaria(arriba);
	  		if (arriba.isEmpty())
	  		{
	  			arriba.addPersonaje(t);
	  		}
	  	}
	 }
  }
  
  public void agregarObstaculo(Obstaculo obstaculo) {
	  
	  	int randomColumna = rdm.nextInt(10);
	  	int randomFila = rdm.nextInt(6);
		mapa[randomFila][randomColumna].addPersonaje(obstaculo);
		obstaculo.setCelda(mapa[randomFila][randomColumna]);
	  
  }
  
  public void agregarComprable(int fila, int columna, Comprable comprable) {
	  mapa[fila][columna].addPersonaje(comprable);
  }
  
  public Celda celdaArriba(Celda c)
  {
	  int i;
	  int j;
	  
	  j = c.getJ();
	  i = c.getI()+1;
	  
	  Celda toRet = new Celda(i, j);
	  return toRet;
  }

  
  /*
  public void asignarPowerUp() {
		System.out.println("ME EJECUTE DESDE ASIGNAR POWER UP");

	  int rdmTorre = rdm.nextInt(2);; //elijo torre al azar de la lista
	  int rdmPowerUp = rdm.nextInt(1); //elijo powerup al azar
	  PowerUp estado;
	  if(rdmPowerUp==1)
		  estado = new Escudo(null);
	  else
		  estado = new BoostAtaque(null); //seteo el power up al azar
	  
	  for(Enemigo m : muertos) { //por cada muerto que tenga power up
		  if(m.tienePowerUp()) {
			  ListaTorres.get(0).setEstado(estado); //obtengo la torre al azar y le seteo el power up
			  estado.asignarPersonaje(ListaTorres.get(rdmTorre)); //seteo la torre en el power up 
			  rdmTorre=rdm.nextInt(3); //vuelvo a elegir torre al azar 
		  }
	  }
  }*/
    
}
