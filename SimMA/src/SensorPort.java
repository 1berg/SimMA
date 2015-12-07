/**
 * Implementation der Klasse SensorPort, die die Ports S1,...,S4 zur Verfügung stellt.
 */
public class SensorPort{

    static SensorPort S1;
    static SensorPort S2;
    static SensorPort S3;
    static SensorPort S4;

    public SensorPort()
    {

        S1 = new SensorPort();
        S2 = new SensorPort();
        S3 = new SensorPort();
        S4 = new SensorPort();
    }
}