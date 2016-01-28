/**
 * Implementation der Klasse SensorPort, die die Ports S1,...,S4 zur Verfügung stellt.
 */
public class SensorPort{

    private int _id;

    private SensorPort(int id)
    {
        _id = id;
    }
    /**
     * The number of ports available.
     */
    public static final int NUMBER_OF_PORTS = 3;

    /**
     * SensorPort S1.
     */
    public static final SensorPort S1 = new SensorPort (0);

    /**
     * SensorPort S2.
     */
    public static final SensorPort S2 = new SensorPort (1);

    /**
     * SensorPort S3.
     */
    public static final SensorPort S3 = new SensorPort (2);

    /**
     * SensorPort S4.
     */
    public static final SensorPort S4 = new SensorPort (3);

    /**
     * Return the MotorPort with the given Id.
     * @param id the Id, between 0 and {@link #NUMBER_OF_PORTS}-1.
     * @return the MotorPort object
     */
    public static SensorPort getInstance(int id)
    {
        switch (id)
        {
            case 0:
                return SensorPort.S1;
            case 1:
                return SensorPort.S2;
            case 2:
                return SensorPort.S3;
            case 3:
                return SensorPort.S4;
            default:
                throw new IllegalArgumentException("no such motor port");
        }
    }


    public int getId()
    {
        return this._id;
    }

}