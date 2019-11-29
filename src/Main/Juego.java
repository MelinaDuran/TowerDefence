package Main;

import java.util.*;


import java.awt.EventQueue;
import GUI.ContadorTiempo;
import GUI.GUI;
import Mapa.Celda;
import Mapa.Mapa;
import Nivel.*;
import Objetos.Personajes.*;
import Objetos.Personajes.enemigos.*;
import Objetos.Personajes.torres.*;
import Visitor.ataque.*;
import Visitor.ataque.disparo.Disparo;
import Visitor.ataque.disparo.ThreadDisparos;
import Objetos.PowerUps.*;
import Objetos.obstaculos.*;
import Objetos.*;


public class Juego {
	private GUI gui;
	private ThreadDisparos threadDisparos;
	private Thread tiempo;
	private Mapa mapa;
    private Nivel nivel;
    private Torre ultimoComprado;
    private int tienda; 
    private boolean estado;    
    private boolean modoVenta;
    private PowerUp powerUpActivo;
    
    private List<Personaje> torres;
    private List<Enemigo> enemigos;
    private List<Disparo> disparos;
    
    private List<Enemigo> muertos;
    
    private List<Obstaculo> obstaculos;

	public Juego() {
		powerUpActivo = null;
		modoVenta = false;
		torres = new LinkedList<Personaje>();
		enemigos = new ArrayList<Enemigo>();
		muertos = new ArrayList<Enemigo>();
		disparos = new LinkedList<Disparo>();
		obstaculos = new LinkedList<Obstaculo>();
		
		mapa = new Mapa();
		
		nivel = new NivelUno(mapa);	
		
		tienda=2500;
		estado=true;
		
		gui = new GUI(this);
	
		tiempo = new ContadorTiempo(this);
		threadDisparos = new ThreadDisparos(this);
		tiempo.start();
		threadDisparos.start();
		
		insertarObstaculos();
		
	}
	
	public List<Enemigo> getEnemigos(){
		return enemigos;
	}
	
	public List<Personaje> getTorres(){
		return torres;
	}
	
	public List<Disparo> getDisparos(){
		return disparos;
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public Mapa getMapa() {
		return mapa;
	}
	
	public GUI getGUI() {
		return gui;
	}
	
	public String getMonedas() {
		return Integer.toString(tienda);
	}
	
	public void setMonedas(int m) {
		tienda = tienda + m;
	}

	/**
	 * Agrega todos los enemigos correspondientes al nivel
	 */
	public synchronized void insertarEnemigos() {
		
		LinkedList<Enemigo> enemigosNivel = nivel.getEnemigos();
		
		if (!enemigosNivel.isEmpty()){
			
			Enemigo e = enemigosNivel.removeFirst();
			enemigos.add(e);
			mapa.agregarEnemigo(e);
			gui.agregarAlTablero(e.getLabel(),e.getCelda());
		}
			

	}
	
	public synchronized void insertarObstaculos() {
		List<Obstaculo> obstaculosNivel = nivel.getObstaculos();
		
		if (!obstaculosNivel.isEmpty()){
			
			for(Obstaculo obstaculo : obstaculosNivel) {
				obstaculos.add(obstaculo);
				mapa.agregarObstaculo(obstaculo);
				gui.agregarAlTablero(obstaculo.getLabel(), obstaculo.getCelda());
			}
			
		}
		
	}
	
	private synchronized void agregarPersonaje(Torre torre, int fila, int columna) {
		
		mapa.agregarPersonaje(torre, fila, columna);
		torres.add(torre);
		gui.agregarAlTablero(torre.getLabel(), torre.getCelda());
		
		if (torre.getCeldaSecundaria() != null){
			gui.agregarAlTablero(torre.getSecondLabel(), torre.getCeldaSecundaria());
		}
	}
	
	 public synchronized void agregarDisparo(Disparo d) {
	  	disparos.add(d);
	 }
	
	//JUEGO FINALIZA: PERDÍ PORQUE ENEMIGOS LLEGARON A LA BASE
	 public void terminar() {
		estado=false;
		gui.juegoTerminado();
	}
	
	
	public void clickSobreTablero(int fila, int columna) {
		if(ultimoComprado!=null) {
			if (ultimoComprado.getTamanio() == 1)
				this.agregarPersonaje(ultimoComprado, fila, columna);
			else
			{
				if (mapa.getCelda(fila-1, columna).isEmpty())
				{
					this.agregarPersonaje(ultimoComprado, fila, columna);
					this.agregarPersonaje(ultimoComprado, ultimoComprado.getCeldaSecundaria().getI()-2, ultimoComprado.getCeldaSecundaria().getJ());
				}
			}
			ultimoComprado=null;
		}
		else
		{
			if (mapa.getCelda(fila, columna).getPowerUp() != null)
			{
				powerUpActivo = mapa.getCelda(fila, columna).getPowerUp();
				gui.actualizarBotonPowerUp(powerUpActivo.getIcon());
				mapa.getCelda(fila, columna).addPowerUp(null);
				gui.sacarDelTablero(powerUpActivo.getLabel());
			}
		}
	}

	public void clickSobrePEF() {
			ultimoComprado = new PlantaEscupeFuego();
			tienda = tienda-ultimoComprado.getPrecio();
	}
	
	public void clickSobreMM() {
		ultimoComprado = new MegaMan();
		tienda = tienda-ultimoComprado.getPrecio();
	}
	
	public void clickSobreDK() {
		ultimoComprado = new DonkeyKong();
		tienda = tienda-ultimoComprado.getPrecio();
	}
	
	public void clickSobreBB() {
		ultimoComprado = new BulletBill();
		tienda = tienda-ultimoComprado.getPrecio();
	}
	
	public void clickSobreSN() {
		ultimoComprado = new Snorlax();
		tienda = tienda-ultimoComprado.getPrecio();
	}
	
	public void clickSobreVender() {
		modoVenta = true;
	}
	
	public void clickSobrePowerUp()
	{
		//Random rnd = new Random();
		//int aux = rnd.nextInt()%torres.size();
		
		//Personaje p = torres.get(aux);
		powerUpActivo.aplicar(torres);
	}
	
	public Celda seleccionarVenta(int fila, int columna)
	{
		Celda toReturn;
		toReturn = mapa.getCelda(fila, columna);
		return toReturn;
	}
	
	public boolean getModoVenta()
	{
		return modoVenta;
	}
	
	public void setModoVenta(boolean b)
	{
		modoVenta = b;
	}
	
	public void vender(Celda c)
	{
		if (!c.isEmpty())
		{
			Personaje p =  (Personaje) c.getPersonaje();
			tienda = tienda + p.getMonedas();
			p.setVida(0);
			//p.setAtaque(0);
			//p.setCelda(null);
			//p.setEstado(null);
			//p.setSprite(null);
			//p.setVelocidadDeAtaque(0);
		}
	}
	
	/*Este método se responsabiliza de MOVER ENEMIGOS
	 * */
	public synchronized boolean moverEnemigos() {
		if(!enemigos.isEmpty()) {
		  for (Enemigo enemigo : enemigos) {
			  Celda celda = enemigo.getCelda();
			  if (celda!=null && (!enemigo.estaMuerto())) {
				  if(celda.getJ()!=0) { 
					  Celda nextCelda = mapa.getCelda(celda.getI(), celda.getJ()-1);
				 	  if(nextCelda.isEmpty()) {
						  celda.removePersonaje();			  
						  nextCelda.addPersonaje(enemigo);
						  enemigo.setCelda(nextCelda);
						  gui.agregarAlTablero(enemigo.getLabel(), enemigo.getCelda());
					  }else {
						  //El enemigo ataca
						  Ataque ataque = new CuerpoACuerpo(enemigo);
						  Personaje p = (Personaje) nextCelda.getPersonaje();
						  p.accept(ataque);							  
					  }			 	  
				  	}
				  else if(celda.getJ()==0) terminar(); //ESTO TERMINA EL JUEGO 
			  	}
		  }
		  return true;
		} else {// se murieron enmegios 2 cosas: 1 pase de nivel o gane el juego
			System.out.println("fin de nivel");
			this.cambiarNivel();
			return false;
		}
}
	  
	
	private synchronized void removerMuertos() {
		 Random rnd = new Random();
		 for(Enemigo enemigo : enemigos) {
			  if(enemigo.estaMuerto()) { 
				  muertos.add(enemigo);
			  }
		  }
		  
		  for(Enemigo muerto : muertos) {
			  if (muerto.getTienePowerUp())
			  {
				  int aux = rnd.nextInt(3);
				  Celda c = muerto.getCelda();
				  PowerUp pow;
				  
				  switch (aux) {
				  	case 0:
					  pow = new BoostAtaque();
					  System.out.println("Agregado: BoostAtaque()");
					  break;
				  	case 1: 
				  		pow = new Escudo();
						System.out.println("Agregado: Escudo()");
				  		break;
				  	case 2: 
				  		pow = new Invulnerabilidad();
				  		System.out.println("Agregado: Invulnerabilidad()");
				  		break;
				  	default:
				  		pow = null;
				  		break;
				  }
				  c.addPowerUp(pow);
				  gui.agregarAlTablero(pow.getLabel(), c);
				  muerto.setPowerUp(false);
			  }
			  enemigos.remove(muerto);
			  muerto.getCelda().removePersonaje();
			  gui.sacarDelTablero(muerto.getLabel());
			  setMonedas(muerto.getMonedas());
			  muerto.morir();
			  gui.refrescarTienda();  
		  }
		  
		  /*
		  if (enemigos.isEmpty())
			  cambiarNivel();
		  */
		  if(torres.size()>3) {
			  //asignarPowerUp();
		  }
	}
	
	private synchronized void removerTorresMuertas() {
		List<Personaje> torresMuertas = new LinkedList<Personaje>();
		for(Personaje torre : torres) {
			if(torre.estaMuerto()) {
				torresMuertas.add(torre);
			}
		}
		
		for(Personaje muerto : torresMuertas) {
			  torres.remove(muerto);
			  muerto.getCelda().removePersonaje();
			  
			  if (muerto.getTamanio() == 2)
			  {
				  Celda aux = mapa.getCelda(muerto.getCeldaSecundaria().getI(), muerto.getCeldaSecundaria().getJ());
				  gui.sacarDelTablero(muerto.getSecondLabel());
				  aux.removePersonaje();
			  }
				  
			  gui.sacarDelTablero(muerto.getLabel());
			  gui.refrescarTienda();  
		  }
	}
	
	private synchronized void removerDisparos() {
		  LinkedList<Disparo> disparosUsados = new LinkedList<Disparo>();
		  for (Disparo d : disparos) {
			  if(!d.getVida()) {
				  disparosUsados.add(d);
			  }
		  }
		  for(Disparo d : disparosUsados) {
			  disparos.remove(d);
			  gui.sacarDelTablero(d.getLabel());
			  d.getCelda().removeDisparo();

		  }
		  removerMuertos();
		  removerTorresMuertas();
	 }
	
	
	public synchronized void moverDisparos() {
		
		  for (Disparo disparo: disparos) {
			  Celda celdaActual = disparo.getCelda();
			  
			  if (celdaActual.getJ()!=9  && this.getEstado() && disparo.getVida()) {
				  Celda siguienteCelda = mapa.getCelda(celdaActual.getI(),celdaActual.getJ()+1);	  
				  if (!siguienteCelda.isEmpty()) {
					  Personaje personaje = (Personaje)siguienteCelda.getPersonaje();
					  personaje.accept(disparo);
				  }
				  else {
					  celdaActual.removeDisparo();
					  siguienteCelda.addDisparo(disparo);
					  disparo.setCelda(siguienteCelda);
					  gui.agregarAlTablero(disparo.getLabel(), disparo.getCelda());
				  } 
			 }
			  else disparo.setVida(false); //faltaba esto para que los disparos se remuevan cuando lleguen al final,
			  							   // tambien lo hace en visitor pero al parecer no lo setea bien 
			
		  }
	  removerDisparos();
	}
	
	//CAMBIA DE NIVEL: ACTUALIZA LOS ENEMIGOS Y LOS INSERTA
	public synchronized void cambiarNivel() {
			  
		this.nivel=nivel.pasarDeNivel(mapa);
		
		if (nivel!=null) {
			
			deleteEnemigos();
			deletePersonajes();
			deleteDisparos();
			deleteObstaculos();
			gui.actualizarLabelOleada();	
			
		}
	}
	//METODO ENCARGADO DE ELIMINAR LOS PERSONAJES PARA ARRANCAR UN NUEVO NIVEL
	private void deletePersonajes() {
		
		for(Personaje torre: torres) {
			torre.getCelda().removePersonaje();
			gui.sacarDelTablero(torre.getLabel());
		}
		
		torres = new LinkedList<Personaje>();
		
	}
	
	private synchronized void deleteDisparos() {
		
		for(Disparo disparo: disparos) {
			disparo.getCelda().removeDisparo();
			gui.sacarDelTablero(disparo.getLabel());
		}
	}
	
	private synchronized void deleteEnemigos() {
		
		for(Enemigo enemigo: enemigos) {
			enemigo.getCelda().removePersonaje();
			gui.sacarDelTablero(enemigo.getLabel());
		}
		
		enemigos = new LinkedList<Enemigo>();
	}
	
	private synchronized void deleteObstaculos() {
		for(Obstaculo obstaculo : obstaculos) {
			obstaculo.getCelda().removePersonaje();
			gui.sacarDelTablero(obstaculo.getLabel());
		}
		
		obstaculos = new LinkedList<Obstaculo>();
	}
	
	
	// ---------------------------METODO PARA INICIAR LA EJECUCION DE LA GUI-------------------------------------/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Juego();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}
	// ---------------------------METODO PARA INICIAR LA EJECUCION DE LA GUI-------------------------------------/
}