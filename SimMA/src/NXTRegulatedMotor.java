import lejos.nxt.MotorPort;


/**
 * Ein NXT-Motor. Wird von der Motor-Klasse benutzt.
 */

public class NXTRegulatedMotor extends Object {

    private Roboter _robot;
    protected int _speed;
    MotorPort _port;

    public NXTRegulatedMotor(MotorPort port){

        _robot = new Roboter();
        _speed = 1;
        _port = port;
        }

    /**
     * Setzen der Geschwindigkeit
     * @param speed
     */
        public void setSpeed(int speed)
        {
                _speed = speed;
        }

    /**
     * Vorwärtsbewegung für den jeweiligen Motor.
     */
        public void forward()
        {
                if (_port.equals(MotorPort.C)) //linker Motor wird angesteuert
                {
                    for(int i=0;i < 36;i++)
                    {
                        _robot.aendereAusrichtung(10); //eventuell andersrum
                        _robot.forward(_speed);
                    }

                }
                else if(_port.equals(MotorPort.B)) //rechter Motor wird angesteuert
                 {
                    for(int i=0; i<36;i++)
                    {
                        _robot.aendereAusrichtung(-10);
                        _robot.forward(_speed);
                    }
                }

        }

        public void backward()
        {
            if (_port.equals(MotorPort.C)) //linker Motor wird angesteuert
            {
                for(int i=0;i < 36;i++)
                {
                    _robot.aendereAusrichtung(-10); //eventuell andersrum
                    _robot.backward(_speed);
                }

            }
            else if(_port.equals(MotorPort.B)) //rechter Motor wird angesteuert
            {
                for(int i=0; i<36;i++)
                {
                    _robot.aendereAusrichtung(10);
                    _robot.backward(_speed);
                }
            }

        }

        public void stop() //TODO Stop implementieren
        {

        }

        public void setAcceleration(int acceleration)
        {

        }

        public void getAcceleration()
        {

        }

        }