package Factory;

import Objetos.Personajes.enemigos.Enemigo;
import Objetos.Personajes.enemigos.LongMoan;
public class FabricaEnemigoLongMoan extends FabricaEnemigo {
    
	public static FabricaEnemigoLongMoan instance=null;
    
    public static FabricaEnemigoLongMoan getFabricaEnemigoLongMoan() {
    	if(instance==null) 
    		instance=new FabricaEnemigoLongMoan();
   	return instance;
    }
    
   private FabricaEnemigoLongMoan() {
	   super();
	   }
   
   public Enemigo crearEnemigo() {
	   return new LongMoan();}
}
