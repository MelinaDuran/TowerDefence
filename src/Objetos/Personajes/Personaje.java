package Objetos.Personajes;
import javax.swing.Icon;
import javax.swing.JLabel;

import Mapa.Celda;
import Objetos.GameObject;
import Visitor.Visitor;
import Visitor.ataque.*;
import Visitor.ataque.disparo.Disparo;
import estadosPersonaje.*;
public abstract class Personaje extends GameObject {
	
	protected int ataque;
	protected int vida;
	protected int rango;
	protected double velocidadDeAtaque;
	protected boolean puedeAtacar;
	protected Celda celda;
	protected Icon spriteDisparo;
	protected int tamanio;
	protected JLabel secondLabel;	
	protected Estado estado;
	
	private int precio;
	
	public Personaje() {
		estado = new Normal();
	}
	
	public int getMonedas() {
		return precio;
	}
	
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Celda getCelda() {
		return celda;
	}
	
	public void setCelda(Celda celda) {
		this.celda=celda;
	}
	
	public boolean estaMuerto() {
		return (vida<1);
	}
	
	public int getAtaque() {
		return this.ataque;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public void restarVida(int ataque) {
		estado.restarVida(ataque,this);
	}
	
	public double getVelocidadDeAtaque() {
		return this.velocidadDeAtaque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	
	public void setVelocidadDeAtaque(int velocidad) {
		this.velocidadDeAtaque= velocidad;
	}
	
	public Icon getSpriteDisparo() {
		return spriteDisparo;
	}

	public abstract Disparo atacar();

	public abstract void accept(Ataque ataque);

	public int getTamanio()
	{
		return tamanio;
	}
	
	public void setCeldaSecundaria(Celda c)
	{
		celdaSec = c;
	}
	
	public Celda getCeldaSecundaria()
	{
		return celdaSec;
	}
	
	public JLabel getSecondLabel()
	{
		return secondLabel;
	}
	
	private Celda celdaSec;

}
