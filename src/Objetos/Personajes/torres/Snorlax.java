package Objetos.Personajes.torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitor.Visitor;
import Visitor.ataque.disparo.DisparoTorre;

public class Snorlax extends Torre{
	public Snorlax()
	{
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Snorlax/idle1.gif"));
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
		visitor = new DisparoTorre(this);
		setCeldaSecundaria(null);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitarTorre(this);
	}
	
	
}
