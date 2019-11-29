package Visitor.ataque;

import Objetos.GameObject;
import Objetos.Personajes.Personaje;

import Visitor.Visitor;

public abstract class Ataque extends GameObject implements Visitor {
	
   private int ataque;
  
   public Ataque(Personaje personaje) {
	   ataque = personaje.getAtaque();
   }

   public int getAtaque() {
	  return ataque;
   }

}
