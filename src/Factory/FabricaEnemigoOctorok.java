package Factory;

import Objetos.Personajes.enemigos.*;

public class FabricaEnemigoOctorok extends FabricaEnemigo
{
	    private static FabricaEnemigoOctorok instance=null;
	    
	    public static FabricaEnemigoOctorok getFabricaEnemigoOctorok() {
	    	if(instance==null) instance=new FabricaEnemigoOctorok();
	   	return instance;
	    }
	    
	   private FabricaEnemigoOctorok() {
		   super();
	   }
	   
	   public Enemigo crearEnemigo() {
		  Octorok e = new Octorok();  
		  return e;
	   }
}
