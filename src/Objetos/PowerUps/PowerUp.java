package Objetos.PowerUps;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Objetos.Personajes.*;
import Visitor.Visitor;
import Objetos.GameObject;

public abstract class PowerUp extends GameObject{
	
	protected JLabel miLabel;
	protected ImageIcon miIcono;
	
	public abstract void aplicar(List<Personaje> personajes);
	
	public abstract void aplicar(Personaje personaje);
	
	public JLabel getLabel()
	{
		return miLabel;
	}
	
	public void setLabel(JLabel j)
	{
		miLabel = j;
	}
	
	public ImageIcon getIcon()
	{
		return miIcono;
	}
	
	public void accept(Visitor visitor) {}
	
	public int getVida() {
		return 0;
	}
	
	
}
