package Factory;

import Objetos.Personajes.enemigos.*;


public class FabricaEnemigoDarkMan extends FabricaEnemigo {
    public static FabricaEnemigoDarkMan instance=null;
    
    public static FabricaEnemigo getFabricaEnemigoDarkMan() {
    	if(instance==null) instance=new FabricaEnemigoDarkMan();	
   	return instance;
    }
    
   private FabricaEnemigoDarkMan() {super();}
   
   public Enemigo crearEnemigo() {return new DarkMan();}
}
