package Objetos.Personajes.enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Octorok extends Enemigo
{
	public Octorok()
	{
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Octorok/idle1.gif"));
		this.ataque = 2;
		this.ataque = 50;
		this.vida = 200;
		this.monedas = 700;
		this.velocidadDeAtaque = 20;
		this.velocidadDeMovimiento = 1;
		this.rango = 50;
		this.label = new JLabel(sprite);
		this.movimientoOriginal = 1;
		this.spriteDisparo = new ImageIcon(this.getClass().getResource("/Main/resources/Octorok/disparo.gif"));
		this.tienePowerUp = tienePowerUp();
	}
}
