package Objetos.Personajes.enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitor.Visitor;
import Visitor.ataque.disparo.DisparoEnemigo;


public class DarkMan extends Enemigo{
	public DarkMan(){
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/DarkMan/idle1.gif"));
		this.ataque = 150;
		this.vida = 100;
		this.monedas = 500;
		this.velocidadDeAtaque = 20;
		this.velocidadDeMovimiento = 1;
		this.rango = 50;
		this.label = new JLabel(sprite);
		this.movimientoOriginal = 1;
		this.tienePowerUp = tienePowerUp();
		visitor = new DisparoEnemigo(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitarEnemigo(this);
	}
}
