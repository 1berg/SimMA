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
        _roboter = new Roboter(100, 500); //Erzeugt einen neuen Roboter an der vorgegebenen Position auf dem Parcours
        new Thread( new Runnable() {@Override public void run() {
            while(true)
            {
                _roboter.update();
                Delay.msDelay(1);
            }
        }}).start();

        System.out.println("xPos:" + _roboter.gibXPosition());
        System.out.println("yPos:" + _roboter.gibYPosition());
        System.out.println("xLichtLinks" + _roboter.gibXLichtLinks());
        System.out.println("yLichtLinks" + _roboter.gibYLichtLinks());
        System.out.println("xLichtRechts" + _roboter.gibXLichtRechts());
        System.out.println("yLichtRechts" + _roboter.gibYLichtRechts());


        /*Motor.C.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
        Motor.B.setSpeed(200);
        Motor.C.forward(); //Linker Motor
        Motor.B.forward();
        //System.out.println(_roboter._winkelVeraenderung);
        Delay.msDelay(2000);
        Motor.C.setSpeed(700);
        Delay.msDelay(2000);
        Motor.C.stop();*/



    }
}