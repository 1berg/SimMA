package Testklassen;

import simma.nxt.*;
import simma.sim.*;

/**
 * Created by Pamina on 26.02.16.
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

    }
}
