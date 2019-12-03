package Visitor.ataque;

import javax.swing.ImageIcon;

import Objetos.GameObject;
import Objetos.Personajes.Personaje;
import Objetos.comprables.Comprable;
import Objetos.comprables.Thwomp;
import Visitor.Visitor;

public abstract class Ataque extends GameObject implements Visitor {
	
   private int ataque;
   private Personaje personaje;
   
   public Ataque(Personaje personaje) {
	   ataque = personaje.getAtaque();
	   this.personaje = personaje;
   }

   public int getAtaque() {
	  return ataque;
   }
   
   public Personaje getPersonaje() {
	   return this.personaje;
   }
   
   public void setPersonaje(Personaje personaje) {
	   this.personaje = personaje;
   }

   public void visitarThwomp(Thwomp thwomp) {
	   thwomp.setVida(thwomp.getVida() - this.getAtaque()/2);
   }

	public void visitarBarricada(Comprable personaje) {
		personaje.setVida(personaje.getVida() - this.getAtaque());
		System.out.println("VIDA BARRERA:"+personaje.getVida());
	}
	
	
	public int getVida() {
		return 0;
	};
	
	public ImageIcon getIcon() {
		return null;
	}
	
	public void accept(Visitor visitor) {}; 
}
