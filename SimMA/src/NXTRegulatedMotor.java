

/**
 * Ein NXT-Motor. Wird von der Motor-Klasse benutzt.
 */

public class NXTRegulatedMotor{


    protected int _speed;
    MotorPort _port;

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
                    for(int i=0;i < 36;i++)
                    {
                        robot.aendereAusrichtung(10); //eventuell andersrum
                        robot.forward(_speed);
                    }

                }
                else if(_port.equals(MotorPort.B)) //rechter Motor wird angesteuert
                 {
                    for(int i=0; i<36;i++)
                    {
                        robot.aendereAusrichtung(-10);
                        robot.forward(_speed);
                    }
                }

        }

        public void backward()
        {
            Roboter robot = Roboter.gibRoboter();
            if (_port.equals(MotorPort.C)) //linker Motor wird angesteuert
            {
                for(int i=0;i < 36;i++)
                {
                    robot.aendereAusrichtung(-10); //eventuell andersrum
                    robot.backward(_speed);
                }

            }
            else if(_port.equals(MotorPort.B)) //rechter Motor wird angesteuert
            {
                for(int i=0; i<36;i++)
                {
                    robot.aendereAusrichtung(10);
                    robot.backward(_speed);
                }
            }

        }

        public void stop()
        {

        }//TODO Stop implementieren


        }