import lejos.util.*;
import lejos.nxt.*;

/**
 * Musterlösung für den Linienfinder.
 *
 */
public class linienfinder 
{
	static LightSensor SeherR = new LightSensor(SensorPort.S4); //Die Lichtsensoren werden mit ihren
    static LightSensor SeherL = new LightSensor(SensorPort.S3); //Ports deklariert/initialisiert.
	
	/**
	 * Die Main-Methode der Klasse
	 */
	public static void main(String[] args)
	{
		while(!Button.ENTER.isPressed()) //Abbruchbedingung, damit der Roboter gestoppt werden kann.
		{
			Motor.A.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
			Motor.B.setSpeed(200);
			
			Motor.A.forward();//Beide Motoren starten.
			Motor.B.forward();
			Delay.msDelay(150);
			
			
			if(SeherL.readValue()<400)
				Motor.A.stop();
				Motor.B.stop(); //Beide Motoren werden gestoppt.
			}
			
			if(SeherR.readValue()<400) //if-Anweisung für den Fall, dass der rechte Sensor die schwarze Linie sieht.
			{
				Motor.A.stop();
				Motor.B.stop(); //Beide Motoren werden gestoppt.
			}
			
			// Das Problem kann natürlich auch mit einer Boolschen Anweisung in einer einzigen
			// if-Anweisung behandelt werden. Hier bietet sich Spielraum für fortgeschrittene
			// Schüler.
		}
	}
}