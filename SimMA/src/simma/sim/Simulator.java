package simma.sim;

import simma.nxt.Delay;

/** Die Klasse Simulator.
 *
 */


public class Simulator
{
    // Ein Parcours wird deklariert
    public static Parcours _parcours;
    // Ein Roboter wird deklariert
    public static Roboter _roboter;
    // Der zugehörige Thread wird deklariert
    public static Thread _thread;



    public Simulator()
    {
        // Die Leinwand sichtbar machen, indem ein neuer Parcours erzeugt wird.
        _parcours = new Parcours();
        // Den Roboter an der vorgegebenen Position auf dem Parcours erzeugen
        _roboter = new Roboter(335, 500);

        new Thread( new Runnable() {@Override public void run() {
            while(true)
            {
                _roboter.update();
                Delay.msDelay(1);
            }
        }}).start();

    }

    private static void main()
    {

    }
}