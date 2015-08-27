import lejos.util.*;
import lejos.nxt.*;

/**
* Musterlösung für den Linienfolger.
*
*/
public class linienfolger 
{
	static LightSensor SeherR = new LightSensor(SensorPort.S4); //Die Lichtsensoren werden mit ihren
    static LightSensor SeherL = new LightSensor(SensorPort.S3); //Ports deklariert/initialisiert.
	Delay.msDelay(1000);

	/**
	 * Die Main-Methode der Klasse
	 */
	public static void main(String[] args)
	{
		while(!Button.ENTER.isPressed()){
			Motor.A.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
			Motor.B.setSpeed(200);
			
			Motor.A.forward();//Beide Motoren starten.
			Motor.B.forward();
			Delay.msDelay(150);
			
			
			if(SeherL.readNormalizedValue()<400) //if-Anweisung für den Fall, dass der linke Sensor die schwarze Linie sieht.
			{
				Motor.A.setSpeed(200);
				Motor.B.setSpeed(200);
				
				Motor.A.backward();
				Motor.B.forward();//Eine Drehung auf der Stelle wird vollzogen.
				Delay.msDelay(250);

			}
			
			if(SeherR.readNormalizedValue()<400) //if-Anweisung für den Fall, dass der rechte Sensor die schwarze Linie sieht.
			{
				Motor.A.setSpeed(200);
				Motor.B.setSpeed(200);
				
				Motor.A.forward();
				Motor.B.backward();
				Delay.msDelay(250);
			}
			
			// Das Problem kann natürlich auch mit einer Boolschen Anweisung in einer einzigen
			// if-Anweisung behandelt werden. Hier bietet sich Spielraum für fortgeschrittene
			// Schüler.
		}
	}
}

