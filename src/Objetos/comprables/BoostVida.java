package Objetos.comprables;
import Objetos.Personajes.torres.*;
import java.util.*;

import javax.swing.ImageIcon;

public class BoostVida extends Comprable{
	
	public BoostVida() {
		precio=550;
		sprite = new ImageIcon("src/Main/resources/Comprables/Vida/icono.png");
	}
	
	public void aplicar(List<Torre> t) {
		for(Torre torre :t) {
			torre.setVida(torre.getVida()+20);
		}
	}
	
	public void activar() {}

}
