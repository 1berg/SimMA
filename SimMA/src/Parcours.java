/**
 * Die Klasse Parcours, in der die ausgewählte Bilddatei in ein Array
 *
 * Created by Pamina on 07.12.15.
 */
public class Parcours {

        // Der Parcours
        private static Parcours parcours;
        // die Bilddaten dieses Bildes
        private short[][] _bilddaten;
        // die Breite dieses Bildes
        private int _breite;
        // die Hoehe dieses Bildes
        private int _hoehe;
        // Leinwand zur Anzeige
        private Leinwand _leinwand;

        /**
         * Initialisiert ein Bild mit einer Bilddatei. Der Benutzer kann interaktiv mit Hilfe eines
         * Dateidialogs die zu ladende Datei auswaehlen.
         */
        public Parcours()
        {
            _bilddaten = BildEinleser.liesBilddaten();
            if (_bilddaten != null)
            {
                aktualisiereBildgroesse(_bilddaten);
                erzeugeLeinwand();

            }
            parcours = this;
        }
    /**
     * Liefert eine Referenz auf das einzige Exemplar dieser Klasse.
     *
     * @return Parcours
     */
    public static Parcours gibParcours()
    {
        return parcours;
    }

    /**
     * Gibt den Helligkeitswert des ausgewählten Pixels auf dem Bild wieder
     * @param x
     * @param y
     * @return Die Bilddaten am Punkt (x|y) normalisiert - die Helligkeit von "weiß" entspricht jetzt 100.
     */
        public double gibHelligkeitswert(int x, int y)
        {
            return (_bilddaten[x][y]/255.0) *100;
        }

    /**
     * Berechnet den Helligkeitwert in einem Bereich von einem Quadrat um den gegebenen Punkt
     * @param x
     *          Die x-Koordinate des Punkts
     * @param y
     *          Die y-Koordinate des Punkte
     * @return den Durchschnitt der Helligkeitswerte um den gewählten Punkt
     */
    public int gibLichtmittelwert(int x, int y)
    {
        double pixel = 0;

        pixel += gibHelligkeitswert(x, y);
        pixel += gibHelligkeitswert(x-1, y-1);
        pixel += gibHelligkeitswert(x, y-1);
        pixel += gibHelligkeitswert(x+1, y-1);
        pixel += gibHelligkeitswert(x-1, y);
        pixel += gibHelligkeitswert(x+1, y);
        pixel += gibHelligkeitswert(x-1, y+1);
        pixel += gibHelligkeitswert(x, y+1);
        pixel += gibHelligkeitswert(x+1, y+1);

        return (int) (pixel / 9.0);
    }


        /**
         * Zeichnet das Bild aus den _bilddaten auf der Leinwand _leinwand
         */
        private void zeichneBild()
        {
            _leinwand.zeichneBild(_bilddaten);
        }


        /**
         * Hoehe und Breite neu berechnen, nachdem die Bilddaten verändert worden sind.
         */
        private void aktualisiereBildgroesse(short[][] bilddaten)
        {
            _hoehe = bilddaten.length;
            if (_hoehe == 0)
            {
                _breite = 0;
            }
            else
            {
                _breite = bilddaten[0].length;
            }
        }

        /**
         * Erzeugt die Leinwand zur Darstellung und zeigt sie an.
         */
        private void erzeugeLeinwand()
        {
            _leinwand = new Leinwand("Parcours", _breite, _hoehe);
            _leinwand.sichtbarMachen();

            zeichneBild();
        }

    }

