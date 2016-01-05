/**
 *
 * Abstraction for a NXT output port.
 *
 */
public class MotorPort {
    private int _id;

    private MotorPort(int id)
    {
        _id = id;
    }

    /**
     * The number of ports available.
     */
    public static final int NUMBER_OF_PORTS = 3;

    /**
     * MotorPort A.
     */
    public static final MotorPort A = new MotorPort (0);

    /**
     * MotorPort B.
     */
    public static final MotorPort B = new MotorPort (1);

    /**
     * MotorPort C.
     */
    public static final MotorPort C = new MotorPort (2);

    /**
     * Return the MotorPort with the given Id.
     * @param id the Id, between 0 and {@link #NUMBER_OF_PORTS}-1.
     * @return the MotorPort object
     */
    public static MotorPort getInstance(int id)
    {
        switch (id)
        {
            case 0:
                return MotorPort.A;
            case 1:
                return MotorPort.B;
            case 2:
                return MotorPort.C;
            default:
                throw new IllegalArgumentException("no such motor port");
        }
    }


    public int getId()
    {
        return this._id;
    }

}
