package Factory;

import Objetos.Personajes.enemigos.Enemigo;
import Objetos.Personajes.enemigos.Goomba;

public class FabricaEnemigoGoomba extends FabricaEnemigo {
    public static FabricaEnemigoGoomba instance=null;
    
    public static FabricaEnemigoGoomba getFabricaEnemigoGoomba() {
    	if(instance==null)instance=new FabricaEnemigoGoomba();
   	return instance;
    }
    
   private FabricaEnemigoGoomba() {super(); }
   
   public Enemigo crearEnemigo() {return new Goomba();}
}
