package es.upm.dit.aled.lab5;

import java.util.LinkedList;
import java.util.Queue;

import es.upm.dit.aled.lab5.gui.Position2D;

/**
 * Extension of Area that maintains a strict queue of the Patients waiting to
 * enter in it. After a Patient exits, the first one in the queue will be
 * allowed to enter.
 * 
 * @author rgarciacarmona
 */
public class AreaQueue extends Area {

private Queue <Patient> waitQueue = new LinkedList <>();
	
public AreaQueue(String name, int time, int capacity, Position2D position) {
	super(name, time, capacity, position);

//Podria declarar declarar Queue <Patient> waitQueue aqui e inicializarlo en el constructor haciendo
// this.waitQueue = new LinkedList<>();
}
@Override
 public synchronized void enter(Patient p) {
	try{
		waitQueue.add(p);
		waiting++;
		while(numPatients==capacity || waitQueue.peek()!=p) {
			wait();
		}
		waitQueue.remove();
		waiting--;
		numPatients++;
	}catch (InterruptedException e) { System.out.print("Ha habido un fallo");
	}
// Es mas claro si dejo dentro del try/catch solo la parte del wait e intento sacar todo lo demás
}

	
	
	
	
}
