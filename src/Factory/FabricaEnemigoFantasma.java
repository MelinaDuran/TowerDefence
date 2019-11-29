package Factory;

import Objetos.Personajes.enemigos.*;
public class FabricaEnemigoFantasma extends FabricaEnemigo {
    public static FabricaEnemigoFantasma instance=null;
    
    public static FabricaEnemigoFantasma getFabricaEnemigoFantasma() {
    	if(instance==null) instance=new FabricaEnemigoFantasma();
   	return instance;
    }
    
   private FabricaEnemigoFantasma() {super();}
   
   public Enemigo crearEnemigo() {return new Fantasma();}
}
