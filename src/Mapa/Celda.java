package Mapa;


import Objetos.GameObject;
import Objetos.PowerUps.PowerUp;

public class Celda {
   protected int posI;
   protected int posJ;
//   protected Personaje p;
//   protected Disparo disparo;
//   protected PowerUp powerUp;
//   protected Comprable comprable;
   
   
   protected GameObject personaje;
   protected GameObject disparo;
   protected GameObject powerUp;
   protected GameObject comprable;
	
   public Celda(int i, int j) {
	   posI=i;
	   posJ=j;
   }
   
   public void addPersonaje(GameObject p) {
	   this.personaje=p;
   }
   
   public GameObject getPersonaje() {
	   return personaje;
   }
   
   public void removePersonaje() {
	   personaje=null;
   }
   public void removeDisparo() {
	   disparo=null;
   }
   
   public void addDisparo(GameObject d) {
	   disparo =d;
   }
   
   public int getI() {
	   return posI;
   }
   
   public int getJ() {
	   return posJ;
   }
   
   public boolean isEmpty() {
	   return personaje==null; 
   }
   
   public void addPowerUp(GameObject powerUp){
	   this.powerUp = powerUp;
   }
   
   public PowerUp getPowerUp(){
	   return (PowerUp) this.powerUp;
   }
   
   public GameObject getComprable(){
	   return comprable;
   }
   
   public void setComprable(GameObject c){
	   comprable = c;
   }
}
