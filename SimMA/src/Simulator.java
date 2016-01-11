/** Die Klasse Simulator.
 *
 */

public class Simulator
{
    public static Parcours _parcours;
    public static Roboter _roboter;

    public Simulator()
    {

    }

    public static void main(String[] args)
    {
        _parcours = new Parcours(); //Macht die Leinwand sichtbar
        _roboter = new Roboter(110, 580); //Erzeugt einen neuen Roboter an der vorgegebenen Position auf dem Parcours

        Motor.A.setSpeed(20); //Geschwindigkeit für beide Motoren festlegen.
        Motor.B.setSpeed(20);

        //Motor.C.forward();//Beide Motoren starten.
        Motor.B.forward();


    }
}