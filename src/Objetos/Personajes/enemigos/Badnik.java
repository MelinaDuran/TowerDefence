package Objetos.Personajes.enemigos;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitor.Visitor;
import Visitor.ataque.disparo.DisparoEnemigo;

public class Badnik extends Enemigo{
	
	public Badnik(){
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Badnik/idle1.gif"));
		this.ataque = 45;
		this.vida = 40;
		this.monedas = 300;
		this.velocidadDeAtaque = 100;
		this.velocidadDeMovimiento = 1;
		this.rango = 0;
		this.label = new JLabel(sprite);
		this.movimientoOriginal = 1;
		visitor = new DisparoEnemigo(this);
		this.tienePowerUp = tienePowerUp();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitarEnemigo(this);
	}
}
