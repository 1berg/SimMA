package simma.nxt;

import simma.sim.Parcours;
import simma.sim.Roboter;

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
     * Sondierende Methode, die dafür sorgt, dass der ausgewählte Lichtsensor die Helligkeit auf dem simma.simma.sim.Parcours liest und ausgibt.
     *
     * @return
     *      Den Helligkeitswert des Bereichs auf dem simma.simma.sim.Parcours unter dem ausgewählten Lichtsensor
     */
    public int readValue()
    {
        Parcours parcours = Parcours.gibParcours();
        Roboter roboter = Roboter.gibRoboter();

        if (_port.equals(SensorPort.S1))
        {
            return parcours.gibLichtmittelwert(roboter.gibXLichtLinks(), roboter.gibYLichtLinks()); //Linker Sensor
        }
        else if (_port.equals(SensorPort.S2))
        {
            return parcours.gibLichtmittelwert(roboter.gibXLichtRechts(), roboter.gibYLichtRechts()); //Rechter Sensor
        }
        else
        {
            return 0;
        }
    }
}

