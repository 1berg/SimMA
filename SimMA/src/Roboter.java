

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by Pamina on 08.01.16.
 */
public class Roboter
{
    private double _xPos;
    private double _yPos;
    private double _ausrichtung = 0;
    BufferedImage _roboter = null;
    private static Roboter roboter;

    /**
     * Kosntruktur für einen neuen Roboter an der Position (x, y)
     *
     * @param x
     * @param y
     */
    public Roboter(int x, int y)
    {

        try
        {
            File file = new File("SimMA/src/images/Roboter.gif");
            _roboter = ImageIO.read(file);
        } catch (IOException e)
        {
            System.out.println("Error beim Laden:" + e.toString());
        }
        Leinwand leinwand = Leinwand.gibLeinwand();
        leinwand.drawImage(_roboter, x, y);
        roboter = this;
        _xPos = x;
        _yPos = y;
    }

    /**
     * Gibt die Referenz auf das Roboterobjekt wieder
     *
     * @return
     */
    public static Roboter gibRoboter()
    {
        return roboter;
    }


    public void forward(int entfernung)
    {
        double radians = Math.toRadians(_ausrichtung);

        // We round to the nearest integer, to allow moving one unit at an angle
        // to actually move.
        int dx = (int) Math.round(Math.cos(radians) * entfernung);
        int dy = (int) Math.round(Math.sin(radians) * entfernung);
        setzePosition((int) _xPos + dx, (int) _yPos + dy);

    }

    public void backward(int entfernung)
    {
        double radians = Math.toRadians(_ausrichtung);

        // We round to the nearest integer, to allow moving one unit at an angle
        // to actually move.
        int dx = (int) Math.round(Math.cos(radians) * (-entfernung));
        int dy = (int) Math.round(Math.sin(radians) * (-entfernung));
        setzePosition((int) _xPos + dx, (int) _yPos + dy);

    }

    public void setzePosition(int x, int y)
    {
        _xPos = x;
        _yPos = y;
        zeichnen((int) _xPos, (int) _yPos);

    }
    /**
     * Bewegung im Koordinatensystem nach oben
     *//*
    public void forward(int entfernung)
    {
        double a = entfernung * Math.sin(_ausrichtung);
        double b = entfernung * Math.cos(_ausrichtung);

        for (int i = 0; i < entfernung; i++)
        {
            _yPos -= b*10;
            System.out.println("y-Pos:" + _yPos);
            _xPos += a*10;
            System.out.println("x-Pos:" + _xPos);
            zeichnen((int) _xPos, (int) _yPos);
        }

    }

    *//**
     * Bewegung im Koordinatensystem nach unten
     *//*
    public void backward(int entfernung)
    {
        double a = entfernung * Math.sin(_ausrichtung);
        double b = entfernung * Math.cos(_ausrichtung);

        for (int i = 0; i < entfernung; i++)
        {
            _yPos += b*10;
            _xPos -= a*10;
            zeichnen((int) _xPos, (int) _yPos);
        }

    }*/

    /**
     * Zeichnet das Roboterobjekt an der Position (x, y) auf die Leinwand
     *
     * @param x
     * @param y
     */
    public void zeichnen(int x, int y)
    {
        Leinwand leinwand = Leinwand.gibLeinwand();
        leinwand.redrawImage();
        leinwand.drawImage(_roboter, x, y);
        leinwand.warte(50);

    }

    /**
     * Die Ausrichtung des Roboters verändern
     */

    public void aendereAusrichtung(int winkel)
    {
        _ausrichtung = (_ausrichtung + winkel) % 360;
    }

    /**
     * Die Position des Roboters auf der x-Achse ausgeben
     */
    public double gibXPosition()
    {
        return _xPos;
    }

    /**
     * Die Position des Roboters auf der y-Achse ausgeben
     */
    public double gibYPosition()
    {
        return _yPos;
    }

    /**
     * Die x-Position des rechten Lichtsensors
     */
    public double gibXLichtRechts()
    {
        double beta = 1 / Math.tan(0.25);
        double epsilon = 90 - (_ausrichtung + beta);
        double c = 5 / Math.sin(beta);
        return _xPos + (c * Math.sin(epsilon));
    }

    /**
     * Die y-Position des rechten Lichtsensors
     */
    public double gibYLichtRechts()
    {
        double beta = 1 / Math.tan(0.25);
        double epsilon = 90 - (_ausrichtung + beta);
        double c = 5 / Math.sin(beta);
        return _yPos + (c * Math.cos(epsilon));
    }

    /**
     * Die x-Position des linken Lichtsensors
     */
    public double gibXLichtLinks()
    {
        double beta = 1 / Math.tan(0.25);
        double gamma = _ausrichtung - beta;
        double c = 5 / Math.sin(beta);
        return _xPos + (c * Math.cos(gamma));
    }

    /**
     * Die y-Position des linken Lichtsensors
     */
    public double gibYLichtLinks()
    {
        double beta = 1 / Math.tan(0.25);
        double gamma = _ausrichtung - beta;
        double c = 5 / Math.sin(beta);
        return _yPos + (c * Math.sin(gamma));
    }


}