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
    private static Roboter roboter;
    public double _winkelVeraenderung = 0;
    private double _geschwindigkeit = 0;

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
     *
     */
    public void update()
    {
        _ausrichtung +=_winkelVeraenderung;
        double radians = Math.toRadians(_ausrichtung);

        // We round to the nearest integer, to allow moving one unit at an angle
        // to actually move.
        int dy = (int) Math.round(Math.cos(radians) * _geschwindigkeit);
        int dx = (int) Math.round(Math.sin(radians) * _geschwindigkeit);
        rotate(_winkelVeraenderung); //TODO Einfach Originalbild beim Zeichnen drehen
        setzePosition((int) _xPos + dx, (int) _yPos - dy);

    }

    /**
     * Bewegt das Roboterobjekt rückwärts.
     *
     * @param entfernung
    public void backward(int entfernung)
    {
        double radians = Math.toRadians(_ausrichtung);

        int dx = (int) (Math.cos(radians) * (-entfernung));
        int dy = (int) (Math.sin(radians) * (-entfernung));
        setzePosition((int) _xPos + dx, (int) _yPos + dy);
    }
*/
    /**
     * Setzt das Roboterobjekt auf die vorgegebene Position
     *
     * @param x
     * @param y
     */
    public void setzePosition(int x, int y)
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
    public void zeichnen(int x, int y)
    {
        Leinwand leinwand = Leinwand.gibLeinwand();
        leinwand.redrawImage();
        leinwand.drawImage(_roboter, x, y);
        leinwand.warte(150); //Bestimmt die Geschwindigkeit des Roboters auf der Leinwand

    }

    /**
     * Die Ausrichtung des Roboters verändern
     *
     */
    public void aendereBewegung(double winkel, double geschwindigkeit)
    {
        System.out.println(winkel+" " + geschwindigkeit);
        _geschwindigkeit += geschwindigkeit;

        //sollte in Abhängigkeit zur Geschwindigkeit die Bewegung ändern
        _winkelVeraenderung += winkel;
    }

    public void stop()
    {
    _geschwindigkeit = 0;
    _winkelVeraenderung = 0;
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
        double beta = Math.toDegrees(Math.atan((47.75 / 77.5)));
        double epsilon = 90 - (_ausrichtung + beta);
        double c = 47.75 * Math.asin(Math.toRadians(beta));
        return _xPos + (c * Math.sin(Math.toRadians(epsilon)));
    }

    /**
     * Die y-Position des rechten Lichtsensors
     */
    public double gibYLichtRechts()
    {
        double beta = Math.toDegrees(Math.atan((47.75 / 77.5)));
        double epsilon = 90 - (_ausrichtung + beta);
        double c = 47.75 * Math.asin(Math.toRadians(beta));
        return _yPos - (c * Math.cos((Math.toRadians(epsilon))));
    }

    /**
     * Die x-Position des linken Lichtsensors
     */
    public double gibXLichtLinks()
    {
        double beta = Math.toDegrees(Math.atan((47.75 / 77.5))); //Ein Viertel der Breite durch die Hälfte der Höhe des Roboters
        double gamma = _ausrichtung - beta;
        double c = 47.75 * Math.asin(Math.toRadians(beta)); //Die Hypothenuse des gedachten Dreiecks
        return _xPos - (c * Math.cos(Math.toRadians(gamma)));
    }

    /**
     * Die y-Position des linken Lichtsensors
     */
    public double gibYLichtLinks()
    {
        double beta = Math.toDegrees(Math.atan((47.75 / 77.5)));
        double gamma = _ausrichtung - beta;
        double c = 47.75 * Math.asin(Math.toRadians(beta));
        return _yPos - (c * Math.sin(Math.toRadians(gamma)));
    }



    //**************************************************************************
    //** Rotate-Method from package javaxt.io.Image
    //**************************************************************************
    /**  Used to rotate the image (clockwise). Rotation angle is specified in
     *   degrees relative to the top of the image.
     */
    public void rotate(double Degrees){

        //Define Image Center (Axis of Rotation)
        int width = _roboter.getWidth();
        int height = _roboter.getHeight();
        int cx = width/2;
        int cy = height/2;

        //create an array containing the corners of the image (TL,TR,BR,BL)
        int[] corners = { 0, 0, width, 0, width, height, 0, height };

        //Define bounds of the image
        int minX, minY, maxX, maxY;
        minX = maxX = cx;
        minY = maxY = cy;
        double theta = Math.toRadians(Degrees);
        for (int i=0; i<corners.length; i+=2){

            //Rotates the given point theta radians around (cx,cy)
            int x = (int) Math.round(
                    Math.cos(theta)*(corners[i]-cx) -
                            Math.sin(theta)*(corners[i+1]-cy)+cx
            );

            int y = (int) Math.round(
                    Math.sin(theta)*(corners[i]-cx) +
                            Math.cos(theta)*(corners[i+1]-cy)+cy
            );

            //Update our bounds
            if(x>maxX) maxX = x;
            if(x<minX) minX = x;
            if(y>maxY) maxY = y;
            if(y<minY) minY = y;
        }


        //Update Image Center Coordinates
        cx = (int)(cx-minX);
        cy = (int)(cy-minY);

        //Create Buffered Image
        BufferedImage result = new BufferedImage(maxX-minX, maxY-minY,
                BufferedImage.TYPE_INT_ARGB);

        //Create Graphics
        Graphics2D g2d = result.createGraphics();

        //Enable anti-alias and Cubic Resampling
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        //Rotate the image
        AffineTransform xform = new AffineTransform();
        xform.rotate(theta,cx,cy);
        g2d.setTransform(xform);
        g2d.drawImage(_roboter,-minX,-minY,null);
        g2d.dispose();

        //Update Class Variables
        this._roboter = result;

        //Delete Heavy Objects
        result = null;
        xform = null;
    }

}