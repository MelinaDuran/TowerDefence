package Objetos.Personajes.enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LongMoan extends Enemigo{
	public LongMoan(){
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/LongMoan/idle1.gif"));
		this.ataque = 65;
		this.vida = 65;
		this.monedas = 450;
		this.velocidadDeAtaque = 23;
		this.velocidadDeMovimiento = 2;
		this.rango = 0;
		this.label = new JLabel(sprite);
		this.movimientoOriginal = 1;
		this.tienePowerUp = tienePowerUp();
	}
}
