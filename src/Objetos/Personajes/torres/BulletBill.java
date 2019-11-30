package Objetos.Personajes.torres;
import javax.swing.ImageIcon;

import Visitor.ataque.Ataque;

public class BulletBill extends Torre {
	public static final double c = 840;
	public BulletBill(){
		sprite = new ImageIcon("src/main/resources/Bullet Bill/idle1.gif");
		spriteDisparo = new ImageIcon("src/main/resources/Bullet Bill/disparo.gif");
		ataque = 250;
		vida = 250;
		precio = 500;
		rango = 5;
		velocidadDeAtaque = 1.6;
		label.setIcon(sprite);
		tamanio = 1;
		
		setCeldaSecundaria(null);
	}
}
