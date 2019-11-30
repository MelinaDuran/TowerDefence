package Mapa;



import Objetos.PowerUps.PowerUp;
import Objetos.comprables.Comprable;
import Objetos.*;
import Objetos.Personajes.Personaje;
import Visitor.ataque.disparo.Disparo;

public class Celda {
   protected int posI;
   protected int posJ;
   protected Personaje p;
   protected Disparo disparo;
   protected PowerUp powerUp;
   protected Comprable comprable;
	
   public Celda(int i, int j) {
	   posI=i;
	   posJ=j;
   }
   
   public void addPersonaje(Personaje p) {
	   this.p=p;
   }
   
   public Personaje getPersonaje() {
	   return p;
   }
   
   public void removePersonaje() {
	   p=null;
   }
   public void removeDisparo() {
	   disparo=null;
   }
   
   public void addDisparo(Disparo d) {
	   disparo =d;
   }
   
   public int getI() {
	   return posI;
   }
   
   public int getJ() {
	   return posJ;
   }
   
   public boolean isEmpty() {
	   return p==null; 
   }
   
   public void addPowerUp(PowerUp p)
   {
	   powerUp = p;
   }
   
   public PowerUp getPowerUp()
   {
	   return powerUp;
   }
   
   public Comprable getComprable()
   {
	   return comprable;
   }
   
   public void setComprable(Comprable c)
   {
	   comprable = c;
   }
}
