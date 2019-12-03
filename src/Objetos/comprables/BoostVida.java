package Objetos.comprables;
import Objetos.Personajes.torres.*;
import Visitor.Visitor;

import java.util.*;

import javax.swing.ImageIcon;

public class BoostVida extends Comprable{
	
	public BoostVida() {
		precio=550;
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Vida/icono.png"));
	}
	
	public void aplicar(List<Torre> t) {
		for(Torre torre :t) {
			torre.setVida(torre.getVida()+20);
		}
	}

	public void accept(Visitor visitor) {}
}
