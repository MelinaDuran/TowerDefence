package Objetos;
import javax.swing.*;
import Visitor.Visitor;
import Mapa.*;

public abstract class GameObject{
	protected Icon sprite;
	protected Visitor miVisitor;
	protected JLabel label = new JLabel();
	protected Celda celda;

	public JLabel getLabel(){
		if(this.label == null) this.label = new JLabel(sprite);
		return this.label;
	}
	
	public void setSprite(Icon s){
		sprite = s;
		this.label = new JLabel(sprite);
	}
}
