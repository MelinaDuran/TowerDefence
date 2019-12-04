package GUI;
import javax.swing.*;
import javax.swing.border.LineBorder;
import Main.Juego;
import Mapa.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GUI extends JFrame{
//-----------------------------------Atributos de Instancia-------------------------------------------------/
	private JButton [] torres;
	private JPanel Tablero;
	private JPanel Botonera;
	private JPanel Monedas;
	private JLabel cantMonedas;
	private Juego juego;
	private JLabel displayMonedas;
	private JLabel lblOleadas;
	private JButton btnVender;
	private JButton btnPowerUp;
//-----------------------------------Atributos de Instancia-------------------------------------------------/
	
//-----------------------CONSTRUCTOR------------------------------------------------------------------------/	
	public GUI(Juego j) {	
		super("Tower Defense");
		this.juego = j;
		setLookAndFeel();
		setAutoRequestFocus(false);
		setForeground(Color.WHITE);
		inicializarGUI();
		inicializarBotonesTorres();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 702);
		this.setVisible(true);
	}	

	private void inicializarGUI() {
		Tablero = new JPanel();
		Tablero.setForeground(Color.RED);
		Tablero.setOpaque(false);
		Tablero.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		Tablero.setBounds(0, 0, 1071, 516);
		Tablero.setBackground(Color.WHITE);
		getContentPane().add(Tablero);
		Tablero.setLayout(null);
		Tablero.addMouseListener(new OyenteClickTablero());

		Botonera = new JPanel();
		Botonera.setBackground(Color.BLACK);
		Botonera.setLayout(new GridLayout(1,5));
		Botonera.setBorder(new LineBorder(new Color(0, 0, 0)));
		Botonera.setLayout(new GridLayout());
		Botonera.setBounds(0, 508, 779, 145);
		getContentPane().add(Botonera);
		
		
			
		Monedas = new JPanel();
		Monedas.setBorder(new LineBorder(new Color(0, 0, 0)));
		Monedas.setBounds(778, 508, 404, 145);
		getContentPane().add(Monedas);
		Monedas.setLayout(null);
		
		btnPowerUp = new JButton("");
		btnPowerUp.setBounds(207, 11, 171, 41);
		btnPowerUp.setEnabled(false);
		btnPowerUp.addActionListener(new OyenteClickPowerUp());
		Monedas.add(btnPowerUp);
		
		btnVender = new JButton();
		btnVender.setBounds(207, 79, 171, 41);
		btnVender.setIcon(new ImageIcon(this.getClass().getResource("/Main/resources/Panel/venderTorre.gif")));
		btnVender.setHorizontalAlignment(SwingConstants.CENTER);
		Monedas.add(btnVender);
		btnVender.addActionListener(new OyenteClickVenta());
		cantMonedas = new JLabel(juego.getMonedas());
		cantMonedas.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 22));
		cantMonedas.setBounds(84, 11, 99, 47);
    	Monedas.add(cantMonedas);
		displayMonedas = new JLabel("");
		displayMonedas.setEnabled(false);
		displayMonedas.setBounds(236, 11, 46, 14);
		Monedas.add(displayMonedas);
		
		lblOleadas = new JLabel("");
		lblOleadas.setFont(new Font("SimSun-ExtB", Font.BOLD | Font.ITALIC, 22));
		lblOleadas.setBounds(84, 86, 115, 33);
		Monedas.add(lblOleadas);
		lblOleadas.setText(""+juego.getNivel().getNroNivel());
		
		JLabel lblMonedita = new JLabel("monedita");
		lblMonedita.setIcon(new ImageIcon(this.getClass().getResource("/Main/resources/Panel/panel.gif")));
		lblMonedita.setBounds(0, 0, 404, 145);
		Monedas.add(lblMonedita);
		
		
		
		getContentPane().setLayout(null);		

		JPanel Fondo = new JPanel();
		Fondo.setBounds(0, -10, 1177, 530);
		getContentPane().add(Fondo);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(this.getClass().getResource("/Main/resources/Mapa.jpg")));
		Fondo.add(Background);
		
		JPanel Comprables = new JPanel();
		Comprables.setBounds(1180, 0, 202, 653);
		getContentPane().add(Comprables);
		Comprables.setLayout(null);
		
		JLabel lblObjetosComprables = new JLabel("Objetos Comprables");
		lblObjetosComprables.setIcon(new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/panelTienda.gif")));
		lblObjetosComprables.setBounds(0, 0, 202, 57);
		Comprables.add(lblObjetosComprables);
		
		JButton botonBomba = new JButton("");
		botonBomba.setIcon(new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Bomba/botonBomba.gif")));
		botonBomba.setBounds(0, 59, 202, 149);
		Comprables.add(botonBomba);
		botonBomba.addActionListener(new OyenteComprarBomba());
		
		JButton botonBarrera = new JButton("");
		botonBarrera.setIcon(new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Barricada/botonBarrera.gif")));
		botonBarrera.setBounds(0, 208, 202, 149);
		Comprables.add(botonBarrera);
		botonBarrera.addActionListener(new OyenteComprarBarrera());
		
		JButton botonVida = new JButton("");
		botonVida.setIcon(new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Vida/botonVida.png")));
		botonVida.setBounds(0, 356, 202, 149);
		Comprables.add(botonVida);
		botonVida.addActionListener(new OyenteComprarBoostVida()); 
		
		JButton botonThwomp = new JButton("");
		botonThwomp.setIcon(new ImageIcon(this.getClass().getResource("/Main/resources/Comprables/Thwomp/botonThwomp.gif")));
		botonThwomp.setBounds(0, 504, 202, 149);
		Comprables.add(botonThwomp);
		botonThwomp.addActionListener(new OyenteComprarThwomp());
	}
	
//-----------------------CONSTRUCTOR------------------------------------------------------------------------/	

//-----------------------COMANDOS------------------------------------------------------------------------/	

	public int getAltoCelda() {return Tablero.getHeight()/6;}
	
	public int getAnchoCelda() {return Tablero.getWidth()/10;}

	public JPanel getTablero(){return Tablero;}
	
	public void agregarAlTablero(JLabel l, Celda c) {
		Tablero.add(l);
		l.setBounds(c.getJ()*getAnchoCelda(), c.getI()*getAltoCelda(), getAnchoCelda(), getAltoCelda());
	}
	
	public void sacarDelTablero(JLabel l) {
		Tablero.remove(l);
		Tablero.repaint();
	}
	
	public void refrescarTienda() {cantMonedas.setText(juego.getMonedas());}
	
	/**
	 * JUEGO TERMINADO: PERDI, LOS ENEMIGOS LLEGARON A LA BASE
	 */
	public void juegoTerminado() {
		int answer = JOptionPane.showConfirmDialog(null, "Juego finalizado, desea volver a jugar?");
		if ( answer == JOptionPane.YES_OPTION) {
			juego = new Juego();
			dispose();
		}
		else if(answer == JOptionPane.NO_OPTION) {
			dispose();
		}
	}

	
	public void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void actualizarBotonPowerUp(ImageIcon j)
	{
		btnPowerUp.setIcon(j);
		btnPowerUp.setEnabled(true);
	}
	
	public void actualizarLabelOleada()
	{
		lblOleadas.setText(""+juego.getNivel().getNroNivel());
	}
//-----------------------COMANDOS------------------------------------------------------------------------/	
public void mostrarMensajeGanador()
{
	JOptionPane.showMessageDialog(getContentPane(),"Ganador!");
	System.exit(0);
}
//---------------------------BOTONES PARA COMPRAR TORRES-----------------------------------------------------/
	private void inicializarBotonesTorres() {
		torres = new JButton[5];
		for(int i=0; i<torres.length; i++) {
			torres[i]= new JButton();
			torres[i].setBorder(new LineBorder(new Color(0,0,0)));
			torres[i].setBackground(new Color(100,100,100));
			Botonera.add(torres[i]);
		}
		
		ImageIcon botonPlantaEscupeFuego = new ImageIcon(this.getClass().getResource("/Main/resources/BotoneraTorres/BotonPlanta.gif"));
		ImageIcon botonMegaMan = new ImageIcon(this.getClass().getResource("/Main/resources/BotoneraTorres/BotonMegaMan.gif"));
		ImageIcon botonDonkeyKong = new ImageIcon(this.getClass().getResource("/Main/resources/BotoneraTorres/BotonDonkeyKong.gif"));
		ImageIcon botonBulletBill = new ImageIcon(this.getClass().getResource("/Main/resources/BotoneraTorres/BotonBulletBill.gif"));
		ImageIcon botonSnorlax = new ImageIcon(this.getClass().getResource("/Main/resources/BotoneraTorres/BotonSnorlax.png"));
		
		
		torres[0].setIcon(botonPlantaEscupeFuego);
		torres[1].setIcon(botonMegaMan);
		torres[2].setIcon(botonDonkeyKong);
		torres[3].setIcon(botonBulletBill);	
		torres[4].setIcon(botonSnorlax);
		
		torres[0].setBackground(Color.BLACK);
		torres[0].setForeground(Color.BLACK);
		
		torres[0].addActionListener(new OyenteClickPEF());
		torres[1].addActionListener(new OyenteClickMM());	
		torres[2].addActionListener(new OyenteClickDK());
		torres[3].addActionListener(new OyenteClickBB());
		torres[4].addActionListener(new OyenteClickSN());
		
		for (int i = 0; i < 5; i++)
			torres[i].setHorizontalAlignment(SwingConstants.CENTER);
		

	}	
//---------------------------BOTONES PARA COMPRAR TORRES----------------------------------------------------/
	
//---------------------------PANEL PARA VER MONEDAS---------------------------------------------------------/


//---------------------------PANEL PARA VER MONEDAS---------------------------------------------------------/
	
//---------------------------OYENTE TABLERO DE JUEGO---------------------------------------------------------/
	private class OyenteClickTablero extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int ancho = Tablero.getWidth()/10;
			int alto = Tablero.getHeight()/6;
			int columna = e.getX()/ancho;
			int fila = e.getY()/alto; 
			if (juego.getModoVenta()){
				Celda c = juego.seleccionarVenta(fila, columna);
				juego.vender(c);
				juego.setModoVenta(false);
			}
			else{
				juego.clickSobreTablero(fila, columna);
			}
		}
	}
//---------------------------OYENTE TABLERO DE JUEGO---------------------------------------------------------/

//---------------------------OYENTE BOTONES DE TORRES---------------------------------------------------------/
	private class OyenteClickPEF implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(Integer.parseInt(juego.getMonedas())>499) {
				juego.clickSobrePEF();
				cantMonedas.setText(juego.getMonedas());
			}	
			else System.out.println("No se puede realizar esta compra");
		}
	}
	
	private class OyenteClickSN implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (Integer.parseInt(juego.getMonedas()) > 599) {
				juego.clickSobreSN();
				cantMonedas.setText(juego.getMonedas());
			}
			else System.out.println("No se puede realizar esta compra");
		}
	}
	
	private class OyenteClickMM implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(Integer.parseInt(juego.getMonedas())>649) {
				juego.clickSobreMM();	
				cantMonedas.setText(juego.getMonedas());
			}	
			else System.out.println("No se puede realizar esta compra");
		}
	}
	
	private class OyenteClickDK implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(Integer.parseInt(juego.getMonedas())>599) {
				juego.clickSobreDK();
				cantMonedas.setText(juego.getMonedas());
			}
			else System.out.println("No se puede realizar esta compra");
		}
	}
	
	private class OyenteClickBB implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(Integer.parseInt(juego.getMonedas())>499) {
				juego.clickSobreBB();
				cantMonedas.setText(juego.getMonedas());
			}
			else System.out.println("No se puede realizar esta compra");
		}	
	}
	
	private class OyenteClickVenta implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			juego.clickSobreVender();
		}	
	}
	
	private class OyenteClickPowerUp implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			juego.clickSobrePowerUp();
			btnPowerUp.setIcon(null);
			btnPowerUp.setEnabled(false);
			repaint();
		}
	}
	
	private class OyenteComprarBomba implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(Integer.parseInt(juego.getMonedas())>=1000) {
				juego.clickSobreComprableBomba();
				cantMonedas.setText(juego.getMonedas());

			}
		}
	}
	
	private class OyenteComprarBarrera implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(Integer.parseInt(juego.getMonedas())>=750) { 
				juego.clickSobreComprableBarrera();
				cantMonedas.setText(juego.getMonedas());
			}
		}
	}
	
	private class OyenteComprarBoostVida implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(Integer.parseInt(juego.getMonedas())>=550) {
				juego.clickSobreComprableBoostVida();
				cantMonedas.setText(juego.getMonedas());
			}
		}
	}
	
	private class OyenteComprarThwomp implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(Integer.parseInt(juego.getMonedas())>=850) {
				juego.clickSobreComprableThwomp();
				cantMonedas.setText(juego.getMonedas());
			}
		}
	}
} 