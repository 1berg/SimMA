import lejos.nxt.MotorPort;


/**
 * Ein NXT-Motor. Wird von der Motor-Klasse benutzt.
 */

public class NXTRegulatedMotor extends Object {

    private Roboter _robot;
    protected float _speed;
    MotorPort _port;

    public NXTRegulatedMotor(MotorPort port){

        _robot = new Roboter();
        _speed = 10;
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
                if (_port.equals('C')) //linker Motor wird angesteuert
                {
                    for(int i=0;i < 36;i++)
                    {
                        _robot.aendereAusrichtung(10);
                        _robot.forward(1);
                    }

                }
                else if(_port.equals('B')) //rechter Motor wird angesteuert
                 {
                    for(int i=0; i<36;i++)
                    {
                        _robot.aendereAusrichtung(-10);
                        _robot:forward(1);
                    }
                }

        }

        public void backward()
        {

        }

        public void stop()
        {

        }

        public void setAcceleration(int acceleration)
        {

        }

        public void getAcceleration()
        {

        }

        }