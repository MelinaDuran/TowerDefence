package Objetos.Personajes.torres;
import javax.swing.ImageIcon;

import Visitor.Visitor;
import Visitor.ataque.disparo.DisparoTorre;

public class BulletBill extends Torre {
	public static final double c = 840;
	public BulletBill(){
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Bullet Bill/idle1.gif"));
		spriteDisparo = new ImageIcon(this.getClass().getResource("/Main/resources/Bullet Bill/disparo.gif"));
		ataque = 250;
		vida = 250;
		precio = 500;
		rango = 5;
		velocidadDeAtaque = 1.6;
		label.setIcon(sprite);
		tamanio = 1;
		visitor = new DisparoTorre(this);
		
		setCeldaSecundaria(null);
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visitarTorre(this);
	}
}
