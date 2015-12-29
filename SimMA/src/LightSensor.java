/**
 * Ein Lichtsensor, der Helligkeitswerte liest.
 * Diese soll die Farbe der Pixel im Bildarray abtasten und die "Lichtwert" zurückgeben.
 */
public class LightSensor
{

    public LightSensor(SensorPort port)
    {

    }

    public int getLightValue()
    {
        return 0;

    }
    public int readValue()
    {
        Parcours parcours = Parcours.gibParcours();
        Roboter roboter = Roboter.gibRoboter();
        return parcours.gibHelligkeitswert(roboter.gibXPosition(), roboter.gibYPosition()); //Hier muss noch die Verschiebung der Positionswerte für die Sensoren einbezogen werden.
    }
}

