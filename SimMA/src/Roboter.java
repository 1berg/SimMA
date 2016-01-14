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
     * @param x
     * @param y
     */
    public Roboter(int x, int y)
    {

        try {
            File file = new File("SimMA/src/images/Roboter.gif");
            _roboter = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Error im Einladen:" + e.toString());
        }
        Leinwand leinwand = Leinwand.gibLeinwand();
        leinwand.drawImage(_roboter, x, y);
        roboter = this;
    }

    /**
     * Gibt die Referenz auf das Roboterobjekt wieder
     * @return
     */
    public static Roboter gibRoboter()
    {
        return roboter;
    }

    /**
     * Bewegung im Koordinatensystem nach oben
     */
    public void forward(int entfernung) {
        int delta = 1;
        //int entfernung = 500;
        double b = entfernung * Math.cos(_ausrichtung);

        for (int i = 0; i < entfernung; i++) {
            _yPos += delta;
            _xPos +=  b / entfernung;
            zeichnen((int) _xPos, (int) _yPos);
        }

    }

    /**
     * Bewegung im Koordinatensystem nach unten
     */
    public void backward(int entfernung) {
        int delta = -1;
        //int entfernung = 500;
        double b = entfernung * Math.cos(_ausrichtung);

        for (int i = 0; i < entfernung; i++)
        {
            _yPos += delta;
            _xPos -=  b / entfernung;
            zeichnen((int) _xPos, (int) _yPos);
        }

    }

    /**
     * Zeichnet das Roboterobjekt an der Position (x, y) auf die Leinwand
     * @param x
     * @param y
     */
    public void zeichnen(int x, int y)
    {
        Leinwand leinwand = Leinwand.gibLeinwand();
        leinwand.redrawImage();
        leinwand.drawImage(_roboter, x, y);

    }

    /**
     * Die Ausrichtung des Roboters verändern
     */

    public void aendereAusrichtung(int winkel)
    {
        _ausrichtung += winkel;
        //roboter.rotate(winkel); //TODO rotate aus der javaxt import klären
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
        double beta = 1/ Math.tan(0.25);
        double epsilon = 90 - (_ausrichtung + beta);
        double c = 5 / Math.sin(beta);
        return _xPos + (c * Math.sin(epsilon));
    }

    /**
     * Die y-Position des rechten Lichtsensors
     */
    public double gibYLichtRechts()
    {
        double beta = 1/ Math.tan(0.25);
        double epsilon = 90 - (_ausrichtung + beta);
        double c = 5 / Math.sin(beta);
        return _yPos + (c * Math.cos(epsilon));
    }

    /**
     * Die x-Position des linken Lichtsensors
     */
    public double gibXLichtLinks()
    {
        double beta = 1/ Math.tan(0.25);
        double gamma = _ausrichtung - beta;
        double c = 5 / Math.sin(beta);
        return _xPos + (c * Math.cos(gamma));
    }

    /**
     * Die y-Position des linken Lichtsensors
     */
    public double gibYLichtLinks()
    {
        double beta = 1/ Math.tan(0.25);
        double gamma = _ausrichtung - beta;
        double c = 5 / Math.sin(beta);
        return _yPos + (c * Math.sin(gamma));
    }

}
