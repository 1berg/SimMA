/** Die Klasse Simulator.
 *
 */

public class Simulator
{
    public static Parcours _parcours;
    public static Roboter _roboter;
    public static Thread _thread;

    public Simulator()
    {

    }

    public static void main(String[] args)
    {
        _parcours = new Parcours(); //Macht die Leinwand sichtbar
        _roboter = new Roboter(100, 200); //Erzeugt einen neuen Roboter an der vorgegebenen Position auf dem Parcours

        new Thread( new Runnable() {@Override public void run() {
            while(true)
            {
                _roboter.update();
                Delay.msDelay(1000);
            }
                      }}).start();

               Motor.C.forward(); //Linker Motor
                Motor.B.forward(); //Rechter Motor

        while(true)
        {
            Motor.C.setSpeed(2); //Geschwindigkeit für beide Motoren festlegen.
            Motor.B.setSpeed(2);
            Motor.C.forward(); //Linker Motor
            Motor.B.forward();
            System.out.println(_roboter._winkelVeraenderung);
            Delay.msDelay(1000);
             Motor.C.setSpeed(-2); //Geschwindigkeit für beide Motoren festlegen.
            Motor.B.setSpeed(-2);
                   Motor.C.forward(); //Linker Motor
                   Motor.B.forward();
                Delay.msDelay(1000);
                Motor.C.setSpeed(0); //Geschwindigkeit für beide Motoren festlegen.
                Motor.B.setSpeed(0);
                   Motor.C.forward(); //Linker Motor
                   Motor.B.forward();
                System.out.println("Eine Runde geschafft ;)");

                    Delay.msDelay(2000);

                        }


    }
}