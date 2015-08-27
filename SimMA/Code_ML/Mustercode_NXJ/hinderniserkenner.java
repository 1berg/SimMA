import lejos.util.*;
import lejos.nxt.*;

/**
 * Musterlösung für den Linienfinder.
 * Hierbei kann entweder der Tastsensor oder der Ultraschallsensor zum Umfahren des Hindernisses
 * benutzt werden.
 * Implementiert sind hier beide Varianten.
 */
public class hinderniserkenner
{
    static TouchSensor Taster = new TouchSensor(SensorPort.S2); //Der Tastsensor.
    static UltrasonicSensor Augen = new UltrasonicSensor(SensorPort.S1); //Der Ultraschallsensor.
    static LightSensor SeherR = new LightSensor(SensorPort.S4); //Die Lichtsensoren werden mit ihren
    static LightSensor SeherL = new LightSensor(SensorPort.S3); //Ports deklariert/initialisiert.

    public static void main(String[] args)
    {
        while(!Button.ENTER.isPressed()){
            Motor.A.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
            Motor.B.setSpeed(200);

            Motor.A.forward();//Beide Motoren starten.
            Motor.B.forward();
            Delay.msDelay(150);

            if(Taster.isPressed()) // Lösung für den Tastsensor
            {
                Motor.A.backward();
                Motor.B.backward();
                Delay.msDelay(800);
                Motor.A.forward();
                Motor.B.backward();
                Delay.msDelay(800);
                Motor.B.setSpeed(270);
                Motor.A.setSpeed(160);
                Motor.B.forward();
                Motor.A.forward();
                Delay.msDelay(7000);
                Motor.A.forward();
                Motor.B.backward();
                Delay.msDelay(250);

            }   

            if(Augen.getDistance() < 10) // Lösung mit dem Ultraschallsensor
            {
                Motor.A.backward();
                Motor.B.backward();
                Delay.msDelay(800);
                Motor.A.forward();
                Motor.B.backward();
                Delay.msDelay(800);
                Motor.B.setSpeed(270);
                Motor.A.setSpeed(160);
                Motor.B.forward();
                Motor.A.forward();
                Delay.msDelay(7000);
                Motor.A.forward();
                Motor.B.backward();
                Delay.msDelay(250);
            }

        }
    }
}