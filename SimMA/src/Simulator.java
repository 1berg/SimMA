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
    //Die Lichtsensoren werden mit ihren Ports deklariert
    static LightSensor SeherR;
    static LightSensor SeherL;


    public Simulator()
    {

    }

    public static void main(String[] args)
    {
        // Die Leinwand sichtbar machen, indem ein neuer Parcours erzeugt wird.
        _parcours = new Parcours();
        // Den Roboter an der vorgegebenen Position auf dem Parcours erzeugen
        _roboter = new Roboter(335, 500);
        // Die Lichtsensoren initialisieren und die Ports zuweisen
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

        /*if(SeherL.readValue()<400) //if-Anweisung für den Fall, dass der linke Sensor die schwarze Linie sieht.
        {
            Motor.A.setSpeed(200);
            Motor.B.setSpeed(200);

            Motor.A.backward();
            Motor.B.forward();//Eine Drehung auf der Stelle wird vollzogen.
            Delay.msDelay(250);

        }

        if(SeherR.readValue()<400) //if-Anweisung für den Fall, dass der rechte Sensor die schwarze Linie sieht.
        {
            Motor.A.setSpeed(200);
            Motor.B.setSpeed(200);

            Motor.A.forward();
            Motor.B.backward();
            Delay.msDelay(250);
        }*/

        /*Motor.C.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
        Motor.B.setSpeed(200);
        Motor.C.forward(); //Linker Motor
        Motor.B.forward();
        //System.out.println(_roboter._winkelVeraenderung);
        Delay.msDelay(2000);
        Motor.C.setSpeed(700);
        Delay.msDelay(2000);
        Motor.C.stop();
        Delay.msDelay(1500);
        Motor.B.stop();*/

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