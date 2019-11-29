package Factory;

import Objetos.Personajes.enemigos.*;

public class FabricaEnemigoBadnik extends FabricaEnemigo {
    private static FabricaEnemigoBadnik instance=null;
    
    public static FabricaEnemigoBadnik getFabricaEnemigoBadnik() {
    	if(instance==null) instance=new FabricaEnemigoBadnik();
   	return instance;
    }
    
   private FabricaEnemigoBadnik() {
	   super();
   }
   
   public Enemigo crearEnemigo() {
	  Badnik e = new Badnik();  
	  return e;
   }
   
}
