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
            _leinwand = new Leinwand("Bildbetrachter", _breite, _hoehe);
            _leinwand.sichtbarMachen();

            zeichneBild();
        }
    }

