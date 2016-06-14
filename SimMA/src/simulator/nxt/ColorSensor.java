package simulator.nxt;

import simulator.sim.Parcours;
import simulator.sim.Roboter;

/**
 * Ein Farbsensor, der als Lichtsensor verwendet werden kann.
 * Genau wie der Lichtsensor, soll hier der Farb- bzw. Helligkeitswert der Pixel im Bildarray abgetastet und ausgegeben werden.
 */

public class ColorSensor
{
    SensorPort _port;

    /**
     * Konstruktor für einen Farbsensor
     *
     * @param port
     *          Der Port, an dem der Farbsensor angeschlossen ist
     */
    public ColorSensor(SensorPort port)
    {
        _port = port;

    }

    public int getLightValue()
    {
        return readValue();

    }

    /**
     * Sondierende Methode, die dafür sorgt, dass der ausgewählte Farbsensor die Helligkeit auf dem simulator.simulator.sim.Parcours liest und ausgibt.
     *
     * @return
     *      Den Helligkeitswert des Bereichs auf dem simulator.simulator.sim.Parcours unter dem ausgewählten Lichtsensor
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

