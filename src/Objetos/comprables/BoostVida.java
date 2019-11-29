package Objetos.comprables;
import Objetos.Personajes.torres.*;
import java.util.*;

public class BoostVida extends Comprable{
	
	public BoostVida() {
		precio=500;
	}
	
	public void aplicar(List<Torre> t) {
		for(Torre torre :t) {
			torre.setVida(torre.getVida()+20);
		}
	}

}
