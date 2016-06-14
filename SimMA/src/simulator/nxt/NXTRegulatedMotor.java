package simulator.nxt;

import simulator.sim.Roboter;

/**
 * Ein NXT-Motor. Dieser wird von der Motor-Klasse benutzt.
 */

public class NXTRegulatedMotor{

    // Variable für die Geschwindigkeit des Roboters
    protected double _speed;
    // Der angesteuerte Port
    MotorPort _port;
    // Die Richtung des Roboters (1 = vorwärts, -1 = rückwarts, 0 = stop)
    private int _richtung = 0;
    // Faktor für die Skalierung der Motorbewegungen im Zusammenhang mit der Winkelveränderung am Roboterobjekt.
    private static double richtungsMultiplikator = 2;

    /**
     * Konstruktor für einen neuen NXTRegulatedMotor
     *
     * @param port
     *          Der Port, an dem der entsprechende simulator.nxt.Motor angeschlossen ist
     */
    public NXTRegulatedMotor(MotorPort port){

        _speed = 1;
        _port = port;
        }

    /**
     * Setzen der Geschwindigkeit
     *
     * @param speed
     */
        public void setSpeed(int speed)
        {
            if (_richtung == 1)
            {
                stop();
                _speed =  (speed / 100.0); //Wenn der Motor bereits an ist, dann muss die veränderte Geschwindigkeit an den Roboter weitergegeben werden.
                forward();
            }
            else if (_richtung == -1)
            {
                stop();
                _speed =  (speed / 100.0);
                backward();
            }
            else
            {
                _speed =  (speed / 100.0);
            }
        }

    /**
     * Vorwärtsbewegung für den jeweiligen Motor.
     * Zweimal forward() führt nicht dazu, dass der Roboter doppelt so schnell fährt.
     */
        public void forward()
        {
            Roboter robot = Roboter.gibRoboter();
            if (_richtung != 1)
            {
                if (_port.equals(MotorPort.B)) //linker Motor wird angesteuert
                {
                    robot.aendereBewegung((_speed)* richtungsMultiplikator, _speed);
                }
                else if (_port.equals(MotorPort.C)) //rechter Motor wird angesteuert
                {
                    robot.aendereBewegung(-(_speed)* richtungsMultiplikator, _speed);
                }
                _richtung = 1;
            }

        }

    /**
     * Rückwärtsbewegung für den jeweiligen Motor.
     * Zweimal backward() soll nicht dazu führen, dass der Roboter doppelt so schnell fährt.
     */

        public void backward()
        {
            Roboter robot = Roboter.gibRoboter();
            if (_richtung != -1)
            {
                if (_port.equals(MotorPort.B)) //linker Motor wird angesteuert
                {
                    robot.aendereBewegung(-(_speed)* richtungsMultiplikator, -_speed);
                }
                else if (_port.equals(MotorPort.C)) //rechter Motor wird angesteuert
                {
                    robot.aendereBewegung((_speed)* richtungsMultiplikator, -_speed);

                }
                _richtung = -1;
            }

        }

    /**
     * Stoppt den angesprochenen Motor.
     * Damit das gesamte Roboter-Objekt auf dem Parcours anhält müssen beide Motoren im Code gestoppt werden.
     */
        public void stop()
        {
            if (_richtung == 1)
            {
                backward();
            }
            else if (_richtung == -1)
            {
                forward();
            }
            _richtung = 0;

        }


}