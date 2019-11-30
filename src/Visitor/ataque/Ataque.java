package Visitor.ataque;

import Objetos.GameObject;
import Objetos.Personajes.Personaje;
import Objetos.comprables.Comprable;
import Objetos.comprables.Thwomp;
import Visitor.Visitor;

public abstract class Ataque extends GameObject implements Visitor {
	
   private int ataque;
  
   public Ataque(Personaje personaje) {
	   ataque = personaje.getAtaque();
   }

   public int getAtaque() {
	  return ataque;
   }

   public void visitarThwomp(Thwomp thwomp) {
	   thwomp.setVida(thwomp.getVida() - this.getAtaque()/2);
   }

	public void visitarBarricada(Comprable personaje) {
		personaje.setVida(personaje.getVida() - this.getAtaque());
		System.out.println("VIDA BARRERA:"+personaje.getVida());
	}
}
