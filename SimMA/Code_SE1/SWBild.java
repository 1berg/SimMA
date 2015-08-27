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
class SWBild
{
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
    public SWBild()
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
    public SWBild(String bilddateiName)
    {
        _bilddaten = BildEinleser.liesBilddaten(bilddateiName);
        aktualisiereBildgroesse(_bilddaten);
        erzeugeLeinwand();
    }

    /**
     * Dieses Bild um einen Wert abdunkeln.
     * 
     * @param delta
     *            Wert der Abdunkelung. Es wird mit dem Betrag von delta gerechnet, 
     *            deshalb darf der Parameter sowohl positiv als auch negativ sein.  
     */
    public void dunkler(int delta)
    {
        if (delta < 0)
        {
            delta = -delta;
        }

        /**
         * Durch alle Bytes des Bildes gehen und jeden Wert dekrementieren
         */
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                if ((_bilddaten[y][x] - delta) > 0) // Wert darf 0 nicht unterschreiten
                {
                    _bilddaten[y][x] = (short) (_bilddaten[y][x] - delta);
                }
                else
                {
                    _bilddaten[y][x] = 0;
                }
            }
        }
         // Neuzeichnen der Bildleinwand, basierend auf den Werten in _bilddaten:
        zeichneBild();
    }

    /**
     * Dieses Bild um einen Wert aufhellen.
     * 
     * @param delta
     *            Wert der Aufhellung. Es wird mit dem Betrag von delta gerechnet, 
     *            deshalb darf der Parameter sowohl positiv als auch negativ sein.  
     */
    public void heller(int delta)
    {
        if (delta < 0)
        {
            delta = -delta;
        }

        /**
         * Durch alle Bytes des Bildes gehen und jeden Wert dekrementieren
         */
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                if ((_bilddaten[y][x] + delta) < 255) // Wert darf 258 nicht ueberschreiten
                {
                    _bilddaten[y][x] = (short) (_bilddaten[y][x] + delta);
                }
                else
                {
                    _bilddaten[y][x] = 255;
                }
            }
        }
        zeichneBild();
    }

    /**
     * Dieses Bild invertieren.
     */
    public void invertieren()
    {
        // Durch alle Bildpunkte des Bildes gehen und jeden Wert "kopieren"
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                _bilddaten[y][x] = (short) (255 - _bilddaten[y][x]);
            }
        }
        zeichneBild();
    }

    /**
     * Dieses Bild horizontal kopieren.
     */
    public void horizontalSpiegeln()
    {
        // Vertausche alle Bildzeilen
        for (int i = 0; i <= _hoehe / 2; i++)
        {
            short[] temp = _bilddaten[i];
            _bilddaten[i] = _bilddaten[_hoehe - 1 - i];
            _bilddaten[_hoehe - 1 - i] = temp;
        }
        zeichneBild();
    }

    /**
     * Dieses Bild weichzeichnen.
     */
    public void weichzeichnen()
    {
        //Neues Array fuer die weichgezeichneten Bilddaten
        short[][] weichgezeichneteBilddaten = new short[_hoehe][_breite];
            
        //Neue Bildpunkte berechnen fuer jedes Pixel
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                //Mittelwert wird anhand des Original-Bild in _bilddaten berechnet
                weichgezeichneteBilddaten[y][x] = mittelWert(y, x); 
            }
        }
        
        //Alte Bilddaten durch weichgezeichnete Bilddaten ersetzen
        _bilddaten = weichgezeichneteBilddaten;
        
        //Bild neu zeichnen
        zeichneBild();
    }

    /**
     * Ermittelt den Mittelwert der umliegenden Bildpunkte.
     * 
     * @return den Mittelwert der umliegenden Bildpunkte.
     */
    private short mittelWert(int y, int x)
    {
        // Ermittele die moeglichen Koordinaten der umliegenden Punkte,
        // wobei auf den Rand des Bildes geachtet werden muss
        int yStart = Math.max(0, y - 1);
        int yStopp = Math.min(_hoehe - 1, y + 1);
        int xStart = Math.max(0, x - 1);
        int xStopp = Math.min(_breite - 1, x + 1);

        int mittelwert = 0;
        int zaehler = 0;
        for (int i = yStart; i <= yStopp; i++)
        {
            for (int j = xStart; j <= xStopp; j++)
            {
                if ((i != y) && (j != x))
                {
                    mittelwert = mittelwert + _bilddaten[i][j];
                    zaehler++;
                }
            }
        }
        return (short) (mittelwert / zaehler);
    }

    /**
     * Erzeuge bei diesem Bild einen Spot mit Radius r, Mittelpunkt x0,y0 und
     * Beleuchtungsintensitaet i Ausserhalb von r nimmt die Ausleuchtung linear ab. Wie im
     * wirklichem Leben...
     * 
     * @param xo
     *            x-Koordinate des Mittelpunktes
     * @param yo
     *            y-Koordinate des Mittelpunktes
     * @param r
     *            Radius
     * @param i
     *            Beleuchtungsintesitaet
     */
    public void spot(int x0, int y0, int r, short i)
    {
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                // Spot
                if (((x - x0) * (x - x0) + (y - y0) * (y - y0)) < r * r)
                {
                    if (_bilddaten[y][x] + i < 256)
                    {
                        _bilddaten[y][x] += i;
                    }
                    else
                    {
                        _bilddaten[y][x] = 255;
                    }
                }

                // Gradient
                else
                {
                    short r0 = (short) (Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0)));

                    if (_bilddaten[y][x] + i - r0 < 256)
                    {
                        if (_bilddaten[y][x] + i - r0 > 0)
                        {
                            _bilddaten[y][x] -= (r0 - i);
                        }
                        else
                        {
                            _bilddaten[y][x] = 0;
                        }
                    }
                    else
                    {
                        _bilddaten[y][x] = 255;
                    }
                }
            }
        }

        zeichneBild();
    }

    /**
     * Gib den Wert eines einzelnen Bildpunktes zurueck.
     * 
     * @param y
     *            die y-Koordinate des Bildpunktes.
     * @param x
     *            die x-Koordinate des Bildpunktes.
     * @return den Wert des angegebenen Bildpunktes.
     */
    public short gibBildpunkt(int y, int x)
    {
        return _bilddaten[y][x];
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
