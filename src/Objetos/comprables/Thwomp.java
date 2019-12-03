package Objetos.comprables;

import javax.swing.ImageIcon;
import Main.Juego;
import Visitor.Visitor;

public class Thwomp extends Comprable{
	public Thwomp(Juego j){
		precio=850;
		vida=650;
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Thwomp/idle1.gif"));
		label.setIcon(sprite);
		miJuego = j;
	}
	
	public void accept(Visitor visitor) {
		visitor.visitarThwomp(this);
	}



}
