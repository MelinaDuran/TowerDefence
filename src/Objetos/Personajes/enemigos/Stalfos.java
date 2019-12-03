package Objetos.Personajes.enemigos;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitor.Visitor;
import Visitor.ataque.disparo.DisparoEnemigo;

public class Stalfos extends Enemigo{
	public Stalfos(){
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/Stalfos/idle1.gif"));
		this.ataque = 75;
		this.vida = 100;
		this.monedas = 400;
		this.velocidadDeAtaque = 60;
		this.velocidadDeMovimiento = 7;
		this.rango = 0;
		this.label = new JLabel(sprite);
		this.movimientoOriginal = 2;
		visitor = new DisparoEnemigo(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitarEnemigo(this);
		
	}
}
