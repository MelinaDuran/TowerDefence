package Objetos.Personajes.torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Snorlax extends Torre{
	public Snorlax()
	{
		sprite = new ImageIcon("src/main/resources/Snorlax/idle1.gif");
		spriteDisparo = null;
		ataque = 0;
		vida = 700;
		precio = 600;
		rango = 5;
		velocidadDeAtaque = 0;
		tamanio = 2;
		label.setIcon(sprite);
		secondLabel = new JLabel();
		secondLabel.setIcon(sprite);
		setCeldaSecundaria(null);
	}
}
