/** Die Klasse Simulator.
 *
 */

public class Simulator
{
    public static Parcours _parcours;
    public static Roboter _roboter;
    public static Thread _thread;
    static LightSensor SeherR; //Die Lichtsensoren werden mit ihren
    static LightSensor SeherL; //Ports deklariert/initialisiert.

    public Simulator()
    {

    }

    public static void main(String[] args)
    {
        _parcours = new Parcours(); //Macht die Leinwand sichtbar
        _roboter = new Roboter(100, 500); //Erzeugt einen neuen Roboter an der vorgegebenen Position auf dem Parcours
        SeherR = new LightSensor(SensorPort.S2);
        SeherL = new LightSensor(SensorPort.S1);

        new Thread( new Runnable() {@Override public void run() {
            while(true)
            {
                _roboter.update();
                Delay.msDelay(1);
            }
        }}).start();


        System.out.println("xPos: " + _roboter.gibXPosition());
        System.out.println("yPos: " + _roboter.gibYPosition());
        System.out.println("xLichtLinks " + _roboter.gibXLichtLinks());
        System.out.println("yLichtLinks " + _roboter.gibYLichtLinks());
        System.out.println("xLichtRechts " + _roboter.gibXLichtRechts());
        System.out.println("yLichtRechts " + _roboter.gibYLichtRechts());


        Motor.C.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
        Motor.B.setSpeed(200);
        Motor.C.forward(); //Linker Motor
        Motor.B.forward();
        //System.out.println(_roboter._winkelVeraenderung);
        Delay.msDelay(2000);
        Motor.C.setSpeed(700);
        Delay.msDelay(2000);
        Motor.C.stop();
        //Motor.B.stop();

        System.out.println("xPos: " + _roboter.gibXPosition());
        System.out.println("yPos: " + _roboter.gibYPosition());
        System.out.println("xLichtLinks " + _roboter.gibXLichtLinks());
        System.out.println("yLichtLinks " + _roboter.gibYLichtLinks());
        System.out.println("xLichtRechts " + _roboter.gibXLichtRechts());
        System.out.println("yLichtRechts " + _roboter.gibYLichtRechts());

        System.out.println("Lichtsensor Links " +  _parcours.gibLichtmittelwert((int) _roboter.gibXLichtLinks(),(int) _roboter.gibYLichtLinks()));
        System.out.println("Lichtsensor Rechts " + _parcours.gibLichtmittelwert((int) _roboter.gibXLichtRechts(), (int)_roboter.gibYLichtRechts()));
    }
}