/**
 * Die Klasse TouchSensor, die einen Berührungssensor simuliert, der vorn am Roboter angeschlossen ist
 */

public class TouchSensor
{
    SensorPort _port;

    /**
     * Konstruktor für einen neuen TouchSensor
     * @param port
     *          Der Port, an dem der Sensor angeschlossen ist.
     */
    public TouchSensor(SensorPort port)
    {
        _port = port;
    }


    /**
     * Gibt Rückmeldung zum Zustand des Sensors (gedrückt/nicht gedrück).
     */
    public boolean isPressed()
    {
        Parcours parcours = Parcours.gibParcours();
        Roboter roboter = Roboter.gibRoboter();

        if ((parcours.gibLichtmittelwert(roboter.gibXTouch(), roboter.gibYTouch()) < 100) && (parcours.gibLichtmittelwert(roboter.gibXTouch(), roboter.gibYTouch()) > 50))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}