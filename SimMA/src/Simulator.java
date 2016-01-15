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
        _roboter = new Roboter(100, 200); //Erzeugt einen neuen Roboter an der vorgegebenen Position auf dem Parcours

        Motor.C.setSpeed(2); //Geschwindigkeit für beide Motoren festlegen.
        Motor.B.setSpeed(2);

        Motor.C.forward();//Beide Motoren starten. Momentan kommt das Programm nicht weiter als bis hierher.
        Motor.B.forward();

    }
}