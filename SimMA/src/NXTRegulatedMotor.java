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

        public void setSpeed(int speed)
        {
                _speed = speed;
        }

    /**
     * Vorwärtsbewegung für den jeweiligen Motor.
     */
        public void forward()
        {
                if (_port.equals('A'))
                {
                    for(int i=0;i < 36;i++)
                    {

                    }

                }
                else if(_port.equals('B') || _port.equals('C'))
                 {
                    for(int i=0; i<36;i++)
                    {

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