//import lejos.util.*;
//import lejos.nxt.*;

import simulator.sim.*;
import simulator.nxt.*;


/**
* Musterlösung für den Linienfolger.
*
*/
public class linienfolger 
{
	static LightSensor SeherR = new LightSensor(SensorPort.S2); //Die Lichtsensoren werden mit ihren
    static LightSensor SeherL = new LightSensor(SensorPort.S1); //Ports deklariert/initialisiert.

    /**
     * Der Konstruktor für einen neuen linienfolger.
     */
    public linienfolger()
    {
        Simulator sim = new Simulator();
    }
    
	/**
	 * Die Methode start der Klasse linienfolger. 
	 */
	public static void start()
	{
	    
		while(!Button.ENTER.isPressed()){
			Motor.C.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
			Motor.B.setSpeed(200);
			
			Motor.C.forward();//Beide Motoren starten.
			Motor.B.forward();
			Delay.msDelay(1500);
			
			
			if(SeherR.readValue()<50 )//if-Anweisung für den Fall, dass der rechte Sensor die schwarze Linie sieht.
			{
				Motor.C.setSpeed(200);
				Motor.B.setSpeed(200);
				
				Motor.C.backward();
				Motor.B.forward();//Eine Drehung auf der Stelle wird vollzogen.
				Delay.msDelay(2500);

			}
			
			if(SeherL.readValue()<50) //if-Anweisung für den Fall, dass der rechte Sensor die schwarze Linie sieht.
			{
				Motor.C.setSpeed(200);
				Motor.B.setSpeed(200);
				
				Motor.C.forward();
				Motor.B.backward();
				Delay.msDelay(2500);
			}
			
			// Das Problem kann natürlich auch mit einer Boolschen Anweisung in einer einzigen
			// if-Anweisung behandelt werden. Hier bietet sich Spielraum für fortgeschrittene
			// Schüler.
		}
	}
}

