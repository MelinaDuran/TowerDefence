package Visitor.ataque.disparo;

import Mapa.Celda;
import Objetos.Personajes.*;
import Visitor.ataque.Ataque;

public abstract class Disparo extends Ataque{
	
   private Celda celda;
   private boolean estaVivo;
   private double velocidadDisparo;
   private int ataque;
  
   public Disparo(Personaje personaje) {
	   super(personaje);
	   estaVivo=true;
	   ataque = personaje.getAtaque();
	   velocidadDisparo = personaje.getVelocidadDeAtaque();
	   celda=personaje.getCelda();
	   setSprite(personaje.getSpriteDisparo());
   }
   
   public boolean getVida() {
	   return estaVivo;
   }
   
   public void setVida(boolean d) {
	   estaVivo=d;
   }
  
   public Celda getCelda() {
	   return celda;
   }
   
   public void setCelda(Celda c) {
	   celda=c;
   }
   
  public double getVelocidad(){
	  return velocidadDisparo;
  }
  
  public int getAtaque() {
	  return ataque;
  }
	
}


