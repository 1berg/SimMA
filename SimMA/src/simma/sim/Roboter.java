package simma.sim;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
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
    BufferedImage _roboterImage = null;
    private static Roboter roboter;
    public double _winkelVeraenderung = 0;
    private double _geschwindigkeit = 0;
    private int _xPosKorrektur = 96;
    private  int _yPosKorrektur = 85;

    /**
     * Konstruktur für einen neuen Roboter an der Position (x, y)
     *
     * @param x
     * @param y
     */
    public Roboter(int x, int y)
    {

        try
        {
            File file = new File("SimMA/src/images/simma.sim.Roboter.gif");
            _roboter = ImageIO.read(file);
            _roboterImage = _roboter;
        } catch (IOException e)
        {
            System.out.println("Error beim Laden:" + e.toString());
        }
        Leinwand leinwand = Leinwand.gibLeinwand();
        leinwand.drawImage(_roboter, x, y);
        roboter = this;
        _xPos = x;
        _yPos = y;
        System.out.println("Breite: " + _roboter.getWidth());
        System.out.println("Höhe: " + _roboter.getHeight());
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


    /**
     * Bewegt das Roboterobjekt vorwärts.
     *
     */
    public void update()
    {
        _ausrichtung +=_winkelVeraenderung;
        double radians = Math.toRadians(_ausrichtung);
        int dy = (int) Math.round(Math.cos(radians) * _geschwindigkeit);
        int dx = (int) Math.round(Math.sin(radians) * _geschwindigkeit);
        rotate(_ausrichtung);
        setzePosition((int) _xPos + dx, (int) _yPos - dy);

    }

    /**
     * Setzt das Roboterobjekt auf die vorgegebene Position
     *
     * @param x
     * @param y
     */
    private void setzePosition(int x, int y)
    {
        _xPos = x;
        _yPos = y;
        zeichnen((int) _xPos, (int) _yPos);
    }


    /**
     * Zeichnet das Roboterobjekt an der Position (x, y) auf die Leinwand
     *
     * @param x
     * @param y
     */
    private void zeichnen(int x, int y)
    {
        Leinwand leinwand = Leinwand.gibLeinwand();
        leinwand.redrawImage();
        leinwand.drawImage(_roboter, x -  _xPosKorrektur, y - _yPosKorrektur);
        leinwand.warte(150); //Bestimmt die Geschwindigkeit des Roboters auf der simma.sim.Leinwand
    }

    /**
     * Die Ausrichtung und die Geschwindigkeit des Roboters ändern
     *
     */
    public void aendereBewegung(double winkel, double geschwindigkeit)
    {
        _geschwindigkeit += geschwindigkeit;
        _winkelVeraenderung += winkel;
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
    public int gibXLichtRechts()
    {
        double beta = Math.toDegrees(Math.atan(((_roboter.getWidth()/4.0) / (_roboter.getHeight()/2.0))));
        double epsilon = 90 - (_ausrichtung + beta);
        double c = (_roboter.getWidth()/4.0) * Math.asin(Math.toRadians(beta));
        return (int) (_xPos + (c * Math.sin(Math.toRadians(epsilon))));
    }

    /**
     * Die y-Position des rechten Lichtsensors
     */
    public int gibYLichtRechts()
    {
        double beta = Math.toDegrees(Math.atan(((_roboter.getWidth()/4.0) / (_roboter.getHeight()/2.0))));
        double epsilon = 90 - (_ausrichtung + beta);
        double c = (_roboter.getWidth()/4.0) * Math.asin(Math.toRadians(beta));
        return (int) (_yPos - (c * Math.cos((Math.toRadians(epsilon)))));
    }

    /**
     * Die x-Position des linken Lichtsensors
     */
    public int gibXLichtLinks()
    {
        double beta = Math.toDegrees(Math.atan(((_roboter.getWidth()/4.0) / (_roboter.getHeight()/2.0)))); //Ein Viertel der Breite durch die Hälfte der Höhe des Roboters
        double gamma = _ausrichtung - beta;
        double c = (_roboter.getWidth()/4.0) * Math.asin(Math.toRadians(beta)); //Die Hypothenuse des gedachten Dreiecks
        return  (int) (_xPos - (c * Math.cos(Math.toRadians(gamma))));
    }

    /**
     * Die y-Position des linken Lichtsensors
     */
    public int gibYLichtLinks()
    {
        double beta = Math.toDegrees(Math.atan(((_roboter.getWidth()/4.0) / (_roboter.getHeight()/2.0))));
        double gamma = _ausrichtung - beta;
        double c = (_roboter.getWidth()/4.0) * Math.asin(Math.toRadians(beta));
        return  (int) (_yPos + (c * Math.sin(Math.toRadians(gamma)))); //TODO Eventuell müssen YLinks und YRechts vertauscht werden - Werte passen jeweils andersrum besser zur Ausrichtung
    }

    /**
     * Gibt die x-Position des Touch-Sensors wieder
     */

    public int gibXTouch()
    {
        double radians = Math.toRadians(_ausrichtung);
        int dx = (int) Math.round(Math.sin(radians) * (_roboter.getWidth()/2.0));
        return (int) (_xPos + dx);

    }

    /**
     * Gibt die y-Position des Touch-Sensors wieder
     * @return
     */
    public int gibYTouch()
    {
        double radians = Math.toRadians(_ausrichtung);
        int dy = (int) Math.round(Math.cos(radians) * (_roboter.getHeight()/2.0));
        return (int) (_yPos - dy);
    }


    /**
     * Rotiert das Bild des Roboters
     */
    private void rotate(double Degrees){

        //Den Bildmittelpunkt bestimmen
        int width = _roboter.getWidth();
        int height = _roboter.getHeight();
        int cx = width/2;
        int cy = height/2;

        //Den Rotationsradius umrechnen
        double theta = Math.toRadians(Degrees);

        //Eine Kopie des Originalbilds erstellen, die rotiert werden soll
        _roboter = new BufferedImage(_roboterImage.getWidth(), _roboterImage.getHeight(),
                BufferedImage.TYPE_INT_ARGB);

        //Graphics2D erstellen, um die Rotation zu ermöglichen, da BufferedImage nicht mit einer AffineTransform zusammenarbeitet
        Graphics2D g2d = _roboter.createGraphics();

        //Enable anti-alias and Cubic Resampling
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC); //TODO brauche ich das hier?

        //Das Bild rotieren und auf die Leinwand bringen
        AffineTransform transform = new AffineTransform();
        transform.rotate(theta,cx,cy);
        g2d.setTransform(transform);
        g2d.drawImage(_roboterImage,0,0,null);
        g2d.dispose();

        //Transformation verwerfen für die nächste Rotation
        transform = null;
    }

}