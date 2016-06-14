package simulator.nxt;

/**
 * simulator.nxt.Motor class contains 3 instances of regulated motors.
 * <p>
 * Example:<p>
 * <code><pre>
 *   simulator.nxt.Motor.A.setSpeed(720);// 2 RPM
 *   simulator.nxt.Motor.C.setSpeed(720);
 *   simulator.nxt.Motor.A.forward();
 *   simulator.nxt.Motor.C.forward();
 *   Thread.sleep (1000);
 *   simulator.nxt.Motor.A.stop();
 *   simulator.nxt.Motor.C.stop();
 *   simulator.nxt.Motor.A.rotateTo( 360);
 *   simulator.nxt.Motor.A.rotate(-720,true);
 *   while(simulator.nxt.Motor.A.isMoving() :Thread.yield();
 *   int angle = simulator.nxt.Motor.A.getTachoCount(); // should be -360
 *   LCD.drawInt(angle,0,0);
 * </pre></code>
 * @author Roger Glassey/Andy Shaw
 */
public class Motor
{
    /**
     * simulator.nxt.Motor A.
     */
    public static final NXTRegulatedMotor A = new NXTRegulatedMotor(MotorPort.A);
    /**
     * simulator.nxt.Motor B.
     */
    public static final NXTRegulatedMotor B = new NXTRegulatedMotor(MotorPort.B);
    /**
     * simulator.nxt.Motor C.
     */
    public static final NXTRegulatedMotor C = new NXTRegulatedMotor(MotorPort.C);

    private Motor() {
       // simulator.nxt.Motor class cannot be instantiated
    }

    /**
     * Return the simulator.nxt.Motor with the given Id.
     * @param id the Id, between 0 and {@link MotorPort#NUMBER_OF_PORTS}-1.
     * @return the simulator.nxt.MotorPort object
     */
    public static NXTRegulatedMotor getInstance(int id)
    {
        switch (id)
        {
            case 0:
                return A;
            case 1:
                return B;
            case 2:
                return C;
            default:
                throw new IllegalArgumentException("no such motor");
        }
    }

}
