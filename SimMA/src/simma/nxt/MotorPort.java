package simma.nxt;

/**
 * Die Klasse MotorPort, mit der die Anschlüsse für die Motoren am NXT-Stein simuliert werden.
 *
 */
public class MotorPort {

    private int _id;

    /**
     * Ein neuer .MotorPort wird über diesen Konstruktor aufgerufen.
     * @param id
     *          Die id des Ports, an dem der NXTRegulatedMotor angeschlossen sein soll
     */
    private MotorPort(int id)
    {
        _id = id;
    }

    /**
     * Die Anzahl der am NXT-Stein zur Verfügung stehenden Ports
     */
    public static final int NUMBER_OF_PORTS = 3;

    /**
     * MotorPort A.
     */
    public static final MotorPort A = new MotorPort(0);

    /**
     * MotorPort B.
     */
    public static final MotorPort B = new MotorPort(1);

    /**
     * MotorPort C.
     */
    public static final MotorPort C = new MotorPort(2);

    /**
     * Return the MotorPort with the given Id.
     * @param id
     *       Die ID, zwischen 0 und {@link #NUMBER_OF_PORTS}-1.
     * @return
     *       Das MotorPort Objekt zur zugehörigen ID
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


    /**
     * Sondierende Methode für die ID
     * @return
     *       Die ID des zugehörigen Ports am ausgewählten simma.nxt.Motor.
     */
    public int getId()
    {
        return this._id;
    }

}
