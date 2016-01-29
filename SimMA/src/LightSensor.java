/**
 * Ein Lichtsensor, der Helligkeitswerte liest.
 * Diese soll die Farbe der Pixel im Bildarray abtasten und die "Lichtwert" zurückgeben.
 */
public class LightSensor
{
    SensorPort _port;

    /**
     * Konstruktor für einen Lichtsensor
     *
     * @param port
     *          Der Port, an dem der Lichtsensor angeschlossen ist
     */
    public LightSensor(SensorPort port)
    {
        _port = port;

    }

    public int getLightValue()
    {
        return readValue();

    }

    /**
     * Sondierende Methode, die dafür sorgt, dass der ausgewählte Lichtsensor die Helligkeit auf dem Parcours liest und ausgibt.
     *
     * @return
     *      Den Helligkeitswert des Bereichs auf dem Parcours unter dem ausgewählten Lichtsensor
     */
    public int readValue()
    {
        Parcours parcours = Parcours.gibParcours();
        Roboter roboter = Roboter.gibRoboter();

        if (_port.equals(SensorPort.S1))
        {
            return parcours.gibLichtmittelwert((int) roboter.gibXLichtLinks(),(int) roboter.gibYLichtLinks()); //Linker Sensor
        }
        else if (_port.equals(SensorPort.S2))
        {
            return parcours.gibLichtmittelwert((int) roboter.gibXLichtRechts(), (int) roboter.gibYLichtRechts()); //Rechter Sensor
        }
        else
        {
            return 0;
        }
    }
}

