package Objetos.PowerUps;

import java.util.*;
import Objetos.Personajes.*;

public abstract class PowerUp {
	
	public abstract void aplicar(List<Personaje> personajes);
	
	public abstract void aplicar(Personaje personaje);
	
}
