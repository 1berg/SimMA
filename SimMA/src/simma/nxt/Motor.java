package simma.nxt;

/**
 * simma.nxt.Motor class contains 3 instances of regulated motors.
 * <p>
 * Example:<p>
 * <code><pre>
 *   simma.nxt.Motor.A.setSpeed(720);// 2 RPM
 *   simma.nxt.Motor.C.setSpeed(720);
 *   simma.nxt.Motor.A.forward();
 *   simma.nxt.Motor.C.forward();
 *   Thread.sleep (1000);
 *   simma.nxt.Motor.A.stop();
 *   simma.nxt.Motor.C.stop();
 *   simma.nxt.Motor.A.rotateTo( 360);
 *   simma.nxt.Motor.A.rotate(-720,true);
 *   while(simma.nxt.Motor.A.isMoving() :Thread.yield();
 *   int angle = simma.nxt.Motor.A.getTachoCount(); // should be -360
 *   LCD.drawInt(angle,0,0);
 * </pre></code>
 * @author Roger Glassey/Andy Shaw
 */
public class Motor
{
    /**
     * simma.nxt.Motor A.
     */
    public static final NXTRegulatedMotor A = new NXTRegulatedMotor(MotorPort.A);
    /**
     * simma.nxt.Motor B.
     */
    public static final NXTRegulatedMotor B = new NXTRegulatedMotor(MotorPort.B);
    /**
     * simma.nxt.Motor C.
     */
    public static final NXTRegulatedMotor C = new NXTRegulatedMotor(MotorPort.C);

    private Motor() {
       // simma.nxt.Motor class cannot be instantiated
    }

    /**
     * Return the simma.nxt.Motor with the given Id.
     * @param id the Id, between 0 and {@link MotorPort#NUMBER_OF_PORTS}-1.
     * @return the simma.nxt.MotorPort object
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
