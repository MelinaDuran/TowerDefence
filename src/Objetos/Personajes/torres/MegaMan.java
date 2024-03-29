package Objetos.Personajes.torres;
import javax.swing.ImageIcon;

import Visitor.Visitor;
import Visitor.ataque.disparo.DisparoTorre;


public class MegaMan extends Torre{
	public static final double c = 500;
	public MegaMan(){
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Mega Man/idle1.gif"));
		spriteDisparo =  new ImageIcon(this.getClass().getResource("/Main/resources/Mega Man/disparo.png"));
		ataque = 150;
		vida = 100;
		precio = 650;
		rango = 5;
		tamanio = 1;
		velocidadDeAtaque = 1.6;
		label.setIcon(sprite);
		visitor = new DisparoTorre(this);
		setCeldaSecundaria(null);
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visitarTorre(this);
	}
}
