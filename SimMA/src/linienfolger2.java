/**
* Musterlösung für den Linienfolger.
*
*/
public class linienfolger2
{
	static Simulator sim = new Simulator();
	static LightSensor SeherR = new LightSensor(SensorPort.S2); //Die Lichtsensoren werden mit ihren
    static LightSensor SeherL = new LightSensor(SensorPort.S1); //Ports deklariert/initialisiert.

	/**
	 * Die Main-Methode der Klasse
	 */
	public static void main(String[] args)
	{
		while(!Button.ENTER.isPressed()){
			Motor.C.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
			Motor.B.setSpeed(200);
			
			Motor.C.forward();//Beide Motoren starten.
			Motor.B.forward();
			Delay.msDelay(1500);

			System.out.println("Links " + SeherL.readValue());
			System.out.println("Rechts " + SeherR.readValue());
			
			if(SeherL.readValue()<50) //if-Anweisung für den Fall, dass der linke Sensor die schwarze Linie sieht.
			{
				System.out.println("Links sieht schwarz " + SeherL.readValue());
				Motor.C.setSpeed(200);
				Motor.B.setSpeed(200);
				
				Motor.B.backward();
				Motor.C.forward();//Eine Drehung auf der Stelle wird vollzogen.
				Delay.msDelay(2500);

			}
			
			if(SeherR.readValue()<50) //if-Anweisung für den Fall, dass der rechte Sensor die schwarze Linie sieht.
			{
				System.out.println("Rechts sieht schwarz " + SeherR.readValue());
				Motor.C.setSpeed(200);
				Motor.B.setSpeed(200);
				
				Motor.B.forward();
				Motor.C.backward();
				Delay.msDelay(2500);
			}
			
			// Das Problem kann natürlich auch mit einer Boolschen Anweisung in einer einzigen
			// if-Anweisung behandelt werden. Hier bietet sich Spielraum für fortgeschrittene
			// Schüler.
		}
	}
}

