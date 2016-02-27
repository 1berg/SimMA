package Testklassen;

import simma.sim.*;
import simma.nxt.*;

/**
 * Musterlösung für den Linienfinder.
 * Hierbei kann entweder der Tastsensor oder der Ultraschallsensor zum Umfahren des Hindernisses
 * benutzt werden.
 * Implementiert sind hier beide Varianten.
 */
public class hindernisTest
{

    static TouchSensor Taster = new TouchSensor(SensorPort.S2); //Der Tastsensor.
    static UltrasonicSensor Augen = new UltrasonicSensor(SensorPort.S1); //Der Ultraschallsensor.


    public static void main(String[] args)
    {
        Simulator sim = new Simulator();
        while(!Button.ENTER.isPressed()){
            Motor.C.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
            Motor.B.setSpeed(200);

            Motor.C.forward();//Beide Motoren starten.
            Motor.B.forward();
            Delay.msDelay(150);

            if(Taster.isPressed()) // Lösung für den Tastsensor
            {
                Motor.C.backward();
                Motor.B.backward();
                Delay.msDelay(800);
                Motor.C.forward();
                Motor.B.backward();
                Delay.msDelay(800);
                Motor.B.setSpeed(270);
                Motor.C.setSpeed(160);
                Motor.B.forward();
                Motor.C.forward();
                Delay.msDelay(7000);
                Motor.C.forward();
                Motor.B.backward();
                Delay.msDelay(250);

            }

            if(Augen.getDistance() < 10) // Lösung mit dem Ultraschallsensor
            {
                Motor.C.backward();
                Motor.B.backward();
                Delay.msDelay(800);
                Motor.C.forward();
                Motor.B.backward();
                Delay.msDelay(800);
                Motor.B.setSpeed(270);
                Motor.C.setSpeed(160);
                Motor.B.forward();
                Motor.C.forward();
                Delay.msDelay(7000);
                Motor.C.forward();
                Motor.B.backward();
                Delay.msDelay(250);
            }

        }
    }
}