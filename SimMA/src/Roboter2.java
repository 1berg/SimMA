import java.awt.*;

/**
 * Created by Pamina on 21.09.15.
 * Repräsentiert ein Roboter-Objekt (bisher als Dreieck)
 *
 */
class Roboter2
{


    private int _xPos;
    private int _yPos;
    private int _breite = 20;
    private int _hoehe = 40;
    private double _ausrichtung = 0;
    private static Roboter2 roboter;

    public Roboter2()
    {

        _xPos = 0;
        _yPos = 0;
        _hoehe = 50;
        _breite = 80;
        roboter = this;

    }

    public Roboter2(int xPos, int yPos)
    {
        _xPos = xPos;
        _yPos = yPos;
        _hoehe = 50;
        _breite = 80;
        roboter = this;
    }

    public static Roboter2 gibRoboter()
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
            loeschen();
            _yPos += delta;
            _xPos += (int) b / entfernung;
            zeichnen();
        }

    }

    /**
     * Bewegung im Koordinatensystem nach unten
     */
    public void backward(int entfernung) {
        int delta = -1;
        //int entfernung = 500;
        double b = entfernung * Math.cos(_ausrichtung);

        for (int i = 0; i < entfernung; i++) {
            loeschen();
            _yPos += delta;
            _xPos -= (int) b / entfernung;
            zeichnen();
        }

    }


    /*
 * Zeichne dieses Dreieck mit seinen aktuellen Werten auf den Bildschirm.
 */
    public void zeichnen() {
        Leinwand leinwand = Leinwand.gibLeinwand();
        int[] xpoints =
                {_xPos, _xPos + (_breite / 2), _xPos - (_breite / 2)};
        int[] ypoints = {_yPos, _yPos + _hoehe, _yPos + _hoehe};
        leinwand.zeichne(this, "blau", new Polygon(xpoints, ypoints, 3));
        leinwand.warte(10);
    }

    /*
     * Loesche dieses Dreieck vom Bildschirm.
     */
    private void loeschen()
    {
            Leinwand leinwand = Leinwand.gibLeinwand();
            //leinwand.entferne(this);
    }


    /**
     * Die Ausrichtung des Roboters verändern
     */

    public void aendereAusrichtung(int winkel)
    {
        _ausrichtung += winkel;
    }

    /**
     * Die Position des Roboters auf der x-Achse ausgeben
     */
    public int gibXPosition()
    {
        return _xPos;
    }

    /**
     * Die Position des Roboters auf der y-Achse ausgeben
     */
    public int gibYPosition()
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

