package GUI;
import Main.Juego;

public class ContadorTiempo extends Thread {
	private Juego juego;
	private final int VELOCIDAD = 1000; //en milis

	public ContadorTiempo(Juego j) {
		this.juego = j;
	}
    
	public void run() {
		
		try {
			
			while(juego.getEstado()) {
				juego.insertarEnemigos();
				juego.moverEnemigos();
				Thread.sleep(VELOCIDAD);
			}					
					
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
	}
	
}