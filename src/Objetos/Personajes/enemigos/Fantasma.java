package Objetos.Personajes.enemigos;


import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Fantasma extends Enemigo{
	
	public Fantasma(){
		sprite = new ImageIcon("src/Main/resources/Fantasma/idle1.png");
		this.ataque = 25;
		this.vida = 55;
		this.monedas = 100;
		this.velocidadDeAtaque = 50;
		this.velocidadDeMovimiento = 1;
		this.rango = 0;
		this.label = new JLabel(sprite);
		this.movimientoOriginal = 1;
		this.tienePowerUp = tienePowerUp();
	}	
}
