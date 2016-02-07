package classes;

/**
 * Die Klasse classes.MotorPort, mit der die Anschlüsse für die Motoren am NXT-Stein simuliert werden.
 *
 */
public class MotorPort {

    private int _id;

    /**
     * Ein neuer classes.MotorPort wird über diesen Konstruktor aufgerufen.
     * @param id
     *          Die id des Ports, an dem der classes.NXTRegulatedMotor angeschlossen sein soll
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
     * classes.MotorPort A.
     */
    public static final MotorPort A = new MotorPort (0);

    /**
     * classes.MotorPort B.
     */
    public static final MotorPort B = new MotorPort (1);

    /**
     * classes.MotorPort C.
     */
    public static final MotorPort C = new MotorPort (2);

    /**
     * Return the classes.MotorPort with the given Id.
     * @param id
     *       Die ID, zwischen 0 und {@link #NUMBER_OF_PORTS}-1.
     * @return
     *       Das classes.MotorPort Objekt zur zugehörigen ID
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
     *       Die ID des zugehörigen Ports am ausgewählten classes.Motor.
     */
    public int getId()
    {
        return this._id;
    }

}
