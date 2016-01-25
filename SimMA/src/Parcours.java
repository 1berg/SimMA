/**
 * Eine Kopie der Klasse SWBild aus dem Bildbearbeitungsprojekt aus SE1
 *
 * Created by Pamina on 07.12.15.
 */
public class Parcours {


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
     * @return Die Bilddaten am Punkt (x|y)
     */
        public int gibHelligkeitswert(int x, int y)
        {
            return _bilddaten[x][y];
        }

    /**
     * Berechnet den Helligkeitwert in einem Bereich von einem Quadrat um den gegebenen Punkt
     * @param x
     * @param y
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

        return (int) pixel / 9;
    }

    // ==== private Hilfsmethoden ====

        /**
         * Zeichnet das Bild in _bilddaten neu
         */
        private void zeichneBild()
        {
            _leinwand.zeichneBild(_bilddaten);
        }

        /**
         * Hoehe und Breite neu berechnen, nachdem die Bilddaten veraendert worden sind.
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
         * Erzeuge die Leinwand zur Darstellung und zeige sie an.
         */
        private void erzeugeLeinwand()
        {
            _leinwand = new Leinwand("Parcours", _breite, _hoehe);
            _leinwand.sichtbarMachen();

            zeichneBild();
        }

    /**
     * Gibt die Breite des Bilds zurück
     *
     * @return _bilddaten.length
     */
        public int gibBildhoehe()
        {
           return _bilddaten.length;
        }

    /**
     * Gibt die Breite des Bilds zurück
     *
     * @return _bilddaten[0].length
     */
        public int gibBildbreite()
        {
            return _bilddaten[0].length;
        }
    }

