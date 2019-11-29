package Objetos.comprables;

public class Barrera extends Comprable{

	public Barrera() {
		precio=500;
		vida=500;
	}
	
	public void recibirDanio(int ataque) {
		if(vida>ataque)
			vida = vida - ataque;
		else
			vida=0;
	}
}
