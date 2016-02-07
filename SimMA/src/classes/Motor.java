package classes;//package lejos.nxt;



/**
 * classes.Motor class contains 3 instances of regulated motors.
 * <p>
 * Example:<p>
 * <code><pre>
 *   classes.Motor.A.setSpeed(720);// 2 RPM
 *   classes.Motor.C.setSpeed(720);
 *   classes.Motor.A.forward();
 *   classes.Motor.C.forward();
 *   Thread.sleep (1000);
 *   classes.Motor.A.stop();
 *   classes.Motor.C.stop();
 *   classes.Motor.A.rotateTo( 360);
 *   classes.Motor.A.rotate(-720,true);
 *   while(classes.Motor.A.isMoving() :Thread.yield();
 *   int angle = classes.Motor.A.getTachoCount(); // should be -360
 *   LCD.drawInt(angle,0,0);
 * </pre></code>
 * @author Roger Glassey/Andy Shaw
 */
public class Motor
{
    /**
     * classes.Motor A.
     */
    public static final NXTRegulatedMotor A = new NXTRegulatedMotor(MotorPort.A);
    /**
     * classes.Motor B.
     */
    public static final NXTRegulatedMotor B = new NXTRegulatedMotor(MotorPort.B);
    /**
     * classes.Motor C.
     */
    public static final NXTRegulatedMotor C = new NXTRegulatedMotor(MotorPort.C);

    private Motor() {
       // classes.Motor class cannot be instantiated
    }

    /**
     * Return the classes.Motor with the given Id.
     * @param id the Id, between 0 and {@link MotorPort#NUMBER_OF_PORTS}-1.
     * @return the classes.MotorPort object
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
