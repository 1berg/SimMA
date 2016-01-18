/**
 * Ein Lichtsensor, der Helligkeitswerte liest.
 * Diese soll die Farbe der Pixel im Bildarray abtasten und die "Lichtwert" zurückgeben.
 */
public class LightSensor
{
    SensorPort _port;

    public LightSensor(SensorPort port)
    {
        _port = port;

    }

    public int getLightValue()
    {
        return 0;

    }
    public int readValue()
    {
        Parcours parcours = Parcours.gibParcours();
        Roboter roboter = Roboter.gibRoboter();
        if (_port.equals(SensorPort.S1))
        {
            //TODO Bestimmten Pixelbereich anschauen und nicht nur ein einzelnen Pixel
            return parcours.gibHelligkeitswert((int) roboter.gibXLichtLinks(),(int) roboter.gibYLichtLinks()); //Linker Sensor
        }
        else if (_port.equals(SensorPort.S2))
        {
            return parcours.gibHelligkeitswert((int) roboter.gibXLichtRechts(), (int) roboter.gibYLichtRechts()); //Rechter Sensor
        }
        else
        {
            return 0;
        }
    }
}

