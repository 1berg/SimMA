

/**
 * Ein NXT-Motor. Wird von der Motor-Klasse benutzt.
 */

public class NXTRegulatedMotor{


    protected double _speed;
    MotorPort _port;
    private int _richtung = 0;
    private static double richtungsMultiplikator = 1./10;

    public NXTRegulatedMotor(MotorPort port){

        _speed = 1;
        _port = port;
        }

    /**
     * Setzen der Geschwindigkeit
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
     * Zweimal forward() soll nicht dazu führen, dass der Roboter doppelt so schnell fährt.
     */
        public void forward()
        {
            Roboter robot = Roboter.gibRoboter();
            if (_richtung != 1)
            {
                if (_port.equals(MotorPort.C)) //linker Motor wird angesteuert
                {
                    robot.aendereBewegung((_speed)* richtungsMultiplikator, _speed); //eventuell andersrum
                }
                else if (_port.equals(MotorPort.B)) //rechter Motor wird angesteuert
                {
                    robot.aendereBewegung(-(_speed)* richtungsMultiplikator, _speed);
                }
                _richtung = 1;
            }

        }


        public void backward()
        {
            Roboter robot = Roboter.gibRoboter();
            if (_richtung != -1)
            {
                if (_port.equals(MotorPort.C)) //linker Motor wird angesteuert
                {
                    robot.aendereBewegung(-(_speed)* richtungsMultiplikator, -_speed); //eventuell andersrum
                }
                else if (_port.equals(MotorPort.B)) //rechter Motor wird angesteuert
                {
                    robot.aendereBewegung((_speed)* richtungsMultiplikator, -_speed);

                }
                _richtung = -1;
            }

        }

    /**
     * Stoppt direkt den ganzen Roboter auf dem Parcours, nicht nur einen Motor.
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