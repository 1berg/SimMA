import java.awt.*;

/**
 * Created by Pamina on 21.09.15.
 * Repräsentiert ein Roboter-Objekt bisher als Dreieck
 *
 */
class Roboter {


    private int _xPos;
    private int _yPos;
    private int _breite = 20;
    private int _hoehe = 40;
    private double _ausrichtung = 0;
    private static Roboter roboter;

    public Roboter() {

        _xPos = 0;
        _yPos = 0;
        _hoehe = 30;
        _breite = 40;

    }

    public Roboter(int xPos, int yPos) {
        _xPos = xPos;
        _yPos = yPos;
        _hoehe = 30;
        _breite = 40;
    }

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

//import java.awt.Polygon;
//
///**
// * Ein Dreieck, das manipuliert werden kann und sich selbst auf einer
// * Leinwand zeichnet.
// *
// * @author  Michael Koelling und David J. Barnes
// * @author  Christian Spaeh
// * @version Oktober 2010
// */
//public class Dreieck
//{
//    private int _hoehe;
//    private int _breite;
//    private int _xPosition;
//    private int _yPosition;
//    private String _farbe;
//    private boolean _istSichtbar;
//
//    /**
//     * Erzeuge ein Dreieck mit einer Standardfarbe an einer Standardposition.
//     * Dieses Dreieck ist vorerst unsichtbar.
//     */
//    public Dreieck()
//    {
//        _hoehe = 30;
//        _breite = 40;
//        _xPosition = 50;
//        _yPosition = 15;
//        _farbe = "gruen";
//        _istSichtbar = false;
//    }
//
//    /**
//     * Mache dieses Dreieck sichtbar. Wenn es bereits sichtbar ist, tue
//     * nichts.
//     */
//    public void sichtbarMachen()
//    {
//        _istSichtbar = true;
//        zeichnen();
//    }
//
//    /**
//     * Mache dieses Dreieck unsichtbar. Wenn es bereits unsichtbar ist, tue
//     * nichts.
//     */
//    public void unsichtbarMachen()
//    {
//        loeschen();
//        _istSichtbar = false;
//    }
//
//    /**
//     * Bewege dieses Dreieck einige Bildschirmpunkte nach rechts.
//     */
//    public void nachRechtsBewegen()
//    {
//        horizontalBewegen(20);
//    }
//
//    /**
//     * Bewege dieses Dreieck einige Bildschirmpunkte nach links.
//     */
//    public void nachLinksBewegen()
//    {
//        horizontalBewegen(-20);
//    }
//
//    /**
//     * Bewege dieses Dreieck einige Bildschirmpunkte nach oben.
//     */
//    public void nachObenBewegen()
//    {
//        vertikalBewegen(-20);
//    }
//
//    /**
//     * Bewege dieses Dreieck einige Bildschirmpunkte nach unten.
//     */
//    public void nachUntenBewegen()
//    {
//        vertikalBewegen(20);
//    }
//
//    /**
//     * Bewege dieses Dreieck horizontal.
//     * @param entfernung
//     *          Die Entfernung in Pixel, um die das Dreieck horizontal bewegt werden soll.
//     */
//    public void horizontalBewegen(int entfernung)
//    {
//        loeschen();
//        _xPosition += entfernung;
//        zeichnen();
//    }
//
//    /**
//     * Bewege dieses Dreieck vertikal.
//     * @param entfernung
//     *          Die Entfernung in Pixel, um die das Dreieck vertikal bewegt werden soll.
//     */
//    public void vertikalBewegen(int entfernung)
//    {
//        loeschen();
//        _yPosition += entfernung;
//        zeichnen();
//    }
//
//    /**
//     * Bewege dieses Dreieck langsam horizontal.
//     * @param entfernung
//     *          Die Entfernung in Pixel, um die das Dreieck horizontal bewegt werden soll.
//     */
//    public void langsamHorizontalBewegen(int entfernung)
//    {
//        int delta;
//
//        if (entfernung < 0)
//        {
//            delta = -1;
//            entfernung = -entfernung;
//        }
//        else
//        {
//            delta = 1;
//        }
//
//        for (int i = 0; i < entfernung; i++)
//        {
//            _xPosition += delta;
//            zeichnen();
//        }
//    }
//
//    /**
//     * Bewege dieses Dreieck langsam vertikal.
//     * @param entfernung
//     *          Die Entfernung in Pixel, um die das Dreieck vertikal bewegt werden soll.
//     */
//    public void langsamVertikalBewegen(int entfernung)
//    {
//        int delta;
//
//        if (entfernung < 0)
//        {
//            delta = -1;
//            entfernung = -entfernung;
//        }
//        else
//        {
//            delta = 1;
//        }
//
//        for (int i = 0; i < entfernung; i++)
//        {
//            _yPosition += delta;
//            zeichnen();
//        }
//    }
//
//    /**
//     * Aendere die Groesse dieses Dreiecks.
//     * @param neueHoehe
//     *          Die neue Hoehe des Dreiecks in Bildschirmpunkten. Diese muss groesser als Null sein.
//     * @param neueBreite
//     *          Die neue Breite des Dreiecks in Bildschirmpunkten. Diese muss groesser als Null sein.
//     */
//    public void groesseAendern(int neueHoehe, int neueBreite)
//    {
//        if((neueHoehe > 0) && (neueBreite > 0)){
//            loeschen();
//            _hoehe = neueHoehe;
//            _breite = neueBreite;
//            zeichnen();
//        }
//    }
//
//    /**
//     * Aendere die Farbe dieses Dreiecks.
//     * @param neueFarbe
//     *          Die neue Farbe des Kreises. Gueltige Angaben sind "rot", "gelb", "blau", "gruen", "lila" und "schwarz".
//     */
//    public void farbeAendern(String neueFarbe)
//    {
//        _farbe = neueFarbe;
//        zeichnen();
//    }
//
//    /*
//     * Zeichne dieses Dreieck mit seinen aktuellen Werten auf den Bildschirm.
//     */
//    private void zeichnen()
//    {
//        if (_istSichtbar)
//        {
//            Leinwand leinwand = Leinwand.gibLeinwand();
//            int[] xpoints =
//                    { _xPosition, _xPosition + (_breite / 2), _xPosition - (_breite / 2)};
//            int[] ypoints = { _yPosition, _yPosition + _hoehe, _yPosition + _hoehe };
//            leinwand.zeichne(this, _farbe, new Polygon(xpoints, ypoints, 3));
//            leinwand.warte(10);
//        }
//    }
//
//    /*
//     * Loesche dieses Dreieck vom Bildschirm.
//     */
//    private void loeschen()
//    {
//        if (_istSichtbar)
//        {
//            Leinwand leinwand = Leinwand.gibLeinwand();
//            leinwand.entferne(this);
//        }
//    }
//}
