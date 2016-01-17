

/**
 * Ein NXT-Motor. Wird von der Motor-Klasse benutzt.
 */

public class NXTRegulatedMotor{


    protected int _speed;
    MotorPort _port;
    boolean _isStopped = false;

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
                _speed = speed;
        }

    /**
     * Vorwärtsbewegung für den jeweiligen Motor.
     */
        public void forward()
        {
            Roboter robot = Roboter.gibRoboter();
            if (_port.equals(MotorPort.C)) //linker Motor wird angesteuert
                {
                    robot.aendereAusrichtung(10, _speed); //eventuell andersrum
                }
                else if (_port.equals(MotorPort.B)) //rechter Motor wird angesteuert
                {
                    robot.aendereAusrichtung(-10, _speed);

                }
            }


        public void backward()
        {
            Roboter robot = Roboter.gibRoboter();
            if (_port.equals(MotorPort.C)) //linker Motor wird angesteuert
            {
                    robot.aendereAusrichtung(-10, -_speed); //eventuell andersrum
            }
            else if(_port.equals(MotorPort.B)) //rechter Motor wird angesteuert
            {
                    robot.aendereAusrichtung(10, -_speed);

            }

        }

        public void stop()
        {
            Roboter robot = Roboter.gibRoboter();
            robot.stop();
            _isStopped = true;
        }


        }