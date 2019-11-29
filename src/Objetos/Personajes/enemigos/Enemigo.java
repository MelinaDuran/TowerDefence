package Objetos.Personajes.enemigos;
import java.util.Random;

import Mapa.*;
import Objetos.Personajes.Personaje;
import Visitor.ataque.*;
import Visitor.ataque.disparo.Disparo;
import Visitor.ataque.disparo.DisparoEnemigo;

public abstract class Enemigo extends Personaje{
	protected int velocidadDeMovimiento;
	protected int monedas;
	protected boolean enMovimiento = true;
	protected int movimientoOriginal;
	protected boolean tienePowerUp;
	//protected Random random;
	
	
	public boolean tienePowerUp() {
		Random random = new Random();
		int rdm = random.nextInt(10);
		if(rdm<=3) tienePowerUp=true;
		
		return tienePowerUp;
	}
	
	public Disparo atacar() {
		return new DisparoEnemigo(this);
	}
	
	public void accept(Ataque ataque) {
		ataque.visitarEnemigo(this);
	}
	
	public void setCelda(Celda p) {
		celda=p;
	}
	
	public Celda getCelda() {
		return celda;
	}

	public int getMonedas() {
		return monedas;
	}
	
	public void setMonedas(int m){
		monedas = m;
	}
	
	public boolean estaMuerto() {
		return (vida < 1);
	}
	
	public int getVida() {
		return vida;
	}

	public int getVelocidadDeMovimiento(){
		return velocidadDeMovimiento;
	}

	public void setVelocidadDeMovimiento(int v){
		velocidadDeMovimiento = v;
	}

	public boolean getMovimiento(){
		return enMovimiento;
	}
	
	public void setMovimiento(boolean b){
		enMovimiento = b;
	}
	
	public int getMovimientoOriginal(){
		return movimientoOriginal;
	}
	
	public void setPowerUp(boolean b)
	{
		tienePowerUp = b;
	}
	
	public boolean getTienePowerUp()
	{
		return tienePowerUp;
	}
	
	public void morir()
	{
		velocidadDeMovimiento = 0;
		monedas = 0;
		enMovimiento = false;
		movimientoOriginal = 0;
		ataque = 0;
		vida = 0;
		sprite = null;
		rango = 0;
	}
}
