/**
 * Eine Kopie der Klasse SWBild aus dem Bildbearbeitungsprojekt aus SE1
 *
 * Created by Pamina on 07.12.15.
 */
public class Parcours {


        // die Bilddaten dieses Bildes
        private short[][] _bilddaten;

        // die Breite dieses Bildes
        private int _breite;

        // die Hoehe dieses Bildes
        private int _hoehe;

        // Leinwand zur Anzeige
        private Leinwand _leinwand;

        private static Parcours parcours;

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
         * Initialisiert ein Bild mit einer Bilddatei. Der Dateiname kann als absoluter oder relativer
         * Pfad uebergeben werden.
         *
         * @param bilddateiName
         *            der Name der Bilddatei
         */
        public Parcours(String bilddateiName)
        {
            _bilddaten = BildEinleser.liesBilddaten(bilddateiName);
            aktualisiereBildgroesse(_bilddaten);
            erzeugeLeinwand();
        }

        public int gibHelligkeitswert(int x, int y)
        {
            return _bilddaten[x][y];
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
    }

