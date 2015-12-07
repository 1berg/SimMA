/**
 * SWBild ist eine Klasse, die Graustufenbilder repraesentiert und
 * manipuliert. Die Implementierung erfolgt durch ein einfaches
 * Bildformat: Die Bildpunkte werden in einem zweidimensionalen
 * Array von 'short'-Werten gehalten. Jeder Feldeintrag kann einen
 * Wert zwischen 0 und 255 annehmen. Andere Werte sind unzulaessig.
 * Der Wertebereich [0..255] repraesentiert den Graustufenbereich:
 * 0 fuer Schwarz, 255 fuer Weiss und dazwischenliegende Werte fuer
 * die Grauabstufungen.
 *
 * Beispielmethode 'dunkler': Ein geladenes Bild kann um
 * ein gegebenes 'delta' abgedunkelt werden.
 *
 * @author  Axel Schmolitzky
 * @version 1.0
 */

/**
 * Created by Pamina on 07.12.15.
 */
public class Parcour {


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
        public Parcour()
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
        public Parcour(String bilddateiName)
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

