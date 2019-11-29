package Objetos.Personajes.enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Goomba extends Enemigo{

	public Goomba(){
		sprite = new ImageIcon("src/Main/resources/Goomba/idle1.gif");
		this.ataque = 50;
		this.vida = 75;
		this.monedas = 250;
		this.velocidadDeAtaque = 50;
		this.velocidadDeMovimiento = 1;
		this.rango = 0;
		this.label = new JLabel(sprite);
		this.movimientoOriginal = 1;
		this.tienePowerUp = tienePowerUp();
	}
}
