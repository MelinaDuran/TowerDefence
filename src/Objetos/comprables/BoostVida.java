package Objetos.comprables;
import Visitor.Visitor;

import javax.swing.ImageIcon;

public class BoostVida extends Comprable{
	
	public BoostVida() {
		precio=550;
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Vida/icono.png"));
	}

	public void accept(Visitor visitor) {
		visitor.visitarBoostVida(this);
	}
}
