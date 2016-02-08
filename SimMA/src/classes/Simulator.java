package classes;

/** Die Klasse classes.Simulator.
 *
 */


public class Simulator
{
    // Ein classes.Parcours wird deklariert
    public static Parcours _parcours;
    // Ein classes.Roboter wird deklariert
    public static Roboter _roboter;
    // Der zugehörige Thread wird deklariert
    public static Thread _thread;
    //Die Lichtsensoren werden mit ihren Ports deklariert
    //static LightSensor SeherR;
    //static LightSensor SeherL;


    public Simulator()
    {
        // Die classes.Leinwand sichtbar machen, indem ein neuer classes.Parcours erzeugt wird.
        _parcours = new Parcours();
        // Den classes.Roboter an der vorgegebenen Position auf dem classes.Parcours erzeugen
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


        /*for(int i = 0; i < 400; i++)
        {
            System.out.println("xPos: " + _roboter.gibXPosition());
            System.out.println("yPos: " + _roboter.gibYPosition());
            System.out.println("xLichtLinks " + _roboter.gibXLichtLinks());
            System.out.println("yLichtLinks " + _roboter.gibYLichtLinks());
            System.out.println("xLichtRechts " + _roboter.gibXLichtRechts());
            System.out.println("yLichtRechts " + _roboter.gibYLichtRechts());
            System.out.println("Lichtwert links " + SeherL.readValue());
            System.out.println("Lichtwert rechts " + SeherR.readValue());
            Motor.B.setSpeed(100);
            Motor.C.setSpeed(100);
            Motor.B.forward();
            Motor.C.forward();
            Delay.msDelay(200);
            i += 1;
        }

        Motor.B.stop();
        Motor.C.stop();*/

        /*if(SeherL.readValue()<400) //if-Anweisung für den Fall, dass der linke Sensor die schwarze Linie sieht.
        {
            classes.Motor.A.setSpeed(200);
            classes.Motor.B.setSpeed(200);

            classes.Motor.A.backward();
            classes.Motor.B.forward();//Eine Drehung auf der Stelle wird vollzogen.
            classes.Delay.msDelay(250);

        }

        if(SeherR.readValue()<400) //if-Anweisung für den Fall, dass der rechte Sensor die schwarze Linie sieht.
        {
            classes.Motor.A.setSpeed(200);
            classes.Motor.B.setSpeed(200);

            classes.Motor.A.forward();
            classes.Motor.B.backward();
            classes.Delay.msDelay(250);
        }*/
 /*
        classes.Motor.C.setSpeed(200); //Geschwindigkeit für beide Motoren festlegen.
        classes.Motor.B.setSpeed(200);
        classes.Motor.C.forward(); //Linker classes.Motor
        classes.Motor.B.forward();
        //System.out.println(_roboter._winkelVeraenderung);
        classes.Delay.msDelay(2000);
        classes.Motor.C.setSpeed(700);
        classes.Delay.msDelay(2000);
        classes.Motor.C.stop();
        classes.Delay.msDelay(1500);
        classes.Motor.B.stop();

        System.out.println("xPos: " + _roboter.gibXPosition());
        System.out.println("yPos: " + _roboter.gibYPosition());
        System.out.println("xLichtLinks " + _roboter.gibXLichtLinks());
        System.out.println("yLichtLinks " + _roboter.gibYLichtLinks());
        System.out.println("xLichtRechts " + _roboter.gibXLichtRechts());
        System.out.println("yLichtRechts " + _roboter.gibYLichtRechts());

        System.out.println("Lichtsensor Links " +  _parcours.gibLichtmittelwert((int) _roboter.gibXLichtLinks(),(int) _roboter.gibYLichtLinks()));
        System.out.println("Lichtsensor Rechts " + _parcours.gibLichtmittelwert((int) _roboter.gibXLichtRechts(), (int)_roboter.gibYLichtRechts()));
        */
    }
}