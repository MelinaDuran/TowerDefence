package Objetos.Personajes.torres;
import javax.swing.*;

import Visitor.ataque.Ataque;

public class PlantaEscupeFuego extends Torre{

	public PlantaEscupeFuego(){
		sprite = new ImageIcon(this.getClass().getResource("/Main/resources/PlantaEscupefuego/idle1.gif"));
		spriteDisparo =new ImageIcon(this.getClass().getResource("/Main/resources/PlantaEscupefuego/bolafuego.png"));
		ataque = 50;
		vida = 100;
		precio = 500;
		rango = 5;
		tamanio = 1;
		velocidadDeAtaque = 1.6;
		label.setIcon(sprite);

		setCeldaSecundaria(null);
	}
}
