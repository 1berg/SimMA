package Testklassen;

import simulator.nxt.*;
import simulator.sim.*;

/**
 * Testklasse zur Vorführung des Simulators.
 * Der Roboter fährt ein Quadrat auf dem ausgewählten Parcours.
 */
public class quadratTest {

    public static void main(String args[])
    {
        Simulator sim = new Simulator();

        Motor.B.setSpeed(100);
        Motor.C.setSpeed(100);

        Motor.B.forward();
        Motor.C.forward();
        Delay.msDelay(4000);
        Motor.B.backward();
        Motor.C.forward();
        Delay.msDelay(7000);
        Motor.B.forward();
        Motor.C.forward();
        Delay.msDelay(4000);
        Motor.B.backward();
        Motor.C.forward();
        Delay.msDelay(7000);
        Motor.B.forward();
        Motor.C.forward();
        Delay.msDelay(4000);
        Motor.B.backward();
        Motor.C.forward();
        Delay.msDelay(7000);
        Motor.B.forward();
        Motor.C.forward();
        Delay.msDelay(4000);
        Motor.B.backward();
        Motor.C.forward();
        Delay.msDelay(7000);
        Motor.B.forward();
        Motor.C.forward();
        Delay.msDelay(2000);
        Motor.B.stop();
        Motor.C.stop();

    }
}
