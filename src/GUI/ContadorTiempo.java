package GUI;
import Main.Juego;

public class ContadorTiempo extends Thread {
	private Juego juego;
	private final int NUM_TANDAS = 3;
	private final int VELOCIDAD = 1000; //en milis

	public ContadorTiempo(Juego j) {
		this.juego = j;
	}
    
	public void run() {
		
		try {
			int tandaActual=0;
			
			// hacete un while con la cant de nivel . que englobea los dos de abajo.
				while(tandaActual<NUM_TANDAS && juego.getEstado()){
					
					int sizeoleada = 0;
					boolean seg = false;
					
					while(sizeoleada<2 && juego.getEstado()) {
						
						if(!seg) {
							juego.insertarEnemigos();
							sizeoleada++;
							seg = true;
						} 
						else 
							seg = false;
						
						
						juego.moverEnemigos();
						
						Thread.sleep(VELOCIDAD);
					}
					tandaActual++;
					// hace un descanso aca y vuelve a meter
				}
	
				boolean rta = true;
				// en el caso que se hayan terminado las tandas, tendran que seguir moviendose los enimigos
				while(juego.getEstado() && rta) {
					rta = juego.moverEnemigos();
					Thread.sleep(VELOCIDAD);
				}
				
/*
				if(juego.getEnemigos().isEmpty()) {
					juego.cambiarNivel();
				}
	*/
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
	}
	
}