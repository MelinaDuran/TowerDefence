package Objetos.Personajes.torres;
import javax.swing.ImageIcon;

import Visitor.Visitor;
import Visitor.ataque.disparo.DisparoTorre;

public class DonkeyKong extends Torre{
	public static final double c = 800;
	public DonkeyKong(){
		super();
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Donkey Kong/idle1.gif"));
		spriteDisparo = new ImageIcon(this.getClass().getResource("/Main/resources/Donkey Kong/disparo.gif"));
		ataque = 500;
		this.vida = 350;
		precio = 600;
		rango = 5;
		tamanio = 1;
		velocidadDeAtaque = 1.6;
		label.setIcon(sprite);
		visitor = new DisparoTorre(this);

		setCelda(null);
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visitarTorre(this);
	}
}
