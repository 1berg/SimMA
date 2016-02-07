import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * Die Klasse Leinwand zum Erzeugen eines aus Pixel bestehenden Bildes
 */
class Leinwand
{
    private JFrame _frame;
    private JMenuBar _menu;
    public CanvasPane _canvas;
    private Graphics2D _graphic;
    private Color _backgroundColour;
    private Image _canvasImage;
    private static Leinwand leinwand;
    private BufferedImage bufferedImage;


    /**
     * Erzeuge eine Leinwand mit einem (weißen) Standardhintergrund.
     *
     * @param title
     *            Der Titel der Leinwand
     * @param width
     *            Die Breite der Leinwand
     * @param height
     *            Die Höhe der Leinwand
     */
    public Leinwand(String title, int width, int height)
    {
        this(title, width, height, Color.white);
    }

    /**
     * Erzeuge eine Leinwand.
     *
     * @param title
     *            Der Titel der Leinwand
     * @param width
     *            Die Breite der Leinwand
     * @param height
     *            Die Höhe der Leinwand
     * @param bgColour
     *            Die Hintergrundfarbe
     */
    public Leinwand(String title, int width, int height, Color bgColour)
    {
        _frame = new JFrame();
        _canvas = new CanvasPane();
        _frame.setContentPane(_canvas);
        _frame.setTitle(title);
        _canvas.setPreferredSize(new Dimension(width, height));
        _backgroundColour = bgColour;
        _frame.pack();
        leinwand = this;
    }

    /**
     * Liefert eine Referenz auf das einzige Exemplar dieser Klasse.
     *
     * @return Leinwand
     */
    public static Leinwand gibLeinwand()
    {
        return leinwand;
    }

    /**
     * Diese Leinwand sichtbar machen. Diese Methode kann auch benutzt werden, um eine sichtbare
     * Leinwand wieder vor andere Fenster zu holen.
     */
    public void sichtbarMachen()
    {
        if (_graphic == null)
        {
            Dimension size = _canvas.getSize();
            _canvasImage = _canvas.createImage(size.width, size.height);
            _graphic = (Graphics2D) _canvasImage.getGraphics();
            _graphic.setColor(_backgroundColour);
            _graphic.fillRect(0, 0, size.width, size.height);
            _graphic.setColor(Color.black);
        }
        _frame.setVisible(true);
    }

    /**
     * Zeichne ein als zweidimensionales short-Array übergebenes Bild auf die Leinwand
     *
     */
    public void zeichneBild(short[][] bild)
    {
        int height = bild.length;
        int width = bild[0].length;

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = (WritableRaster) bufferedImage.getData();

        int[] rgb = new int[3];

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                rgb[0] = bild[y][x];
                rgb[1] = bild[y][x];
                rgb[2] = bild[y][x];
                raster.setPixel(x, y, rgb);
            }
        }
        bufferedImage.setData(raster);
        drawImage(bufferedImage, 0, 0);
    }

    /**
     * Zeichnet das Bild erneut
     */
    public void redrawImage()
    {
        drawImage(bufferedImage,0,0);
    }

    /**
     * Zeichnet ein Image auf die Leinwand
     *
     * @param image
     *            das Image Objekt
     * @param x
     *            x-Koordinate
     * @param y
     *            y-Koordinate
     * @return Gibt true/false zurück als Status, ob das Bild vollständig geladen wurde
     */
    public boolean drawImage(Image image, int x, int y)
    {
        boolean result = _graphic.drawImage(image, x, y, null);
        _canvas.repaint();
        return result;
    }

    /**
     * Warte fuer die angegebenen Millisekunden. Mit dieser Operation wird eine
     * Verzögerung definiert, die für animierte Zeichnungen benutzt werden
     * kann.
     *
     * @param millisekunden
     *            die zu wartenden Millisekunden
     */
    public void warte(int millisekunden)
    {
        try
        {
            Thread.sleep(millisekunden);
        }
        catch (Exception e)
        {
            //Exception wird ignoriert
        }
    }


    /************************************************************************
     * Nested class CanvasPane - the actual canvas component contained in the Canvas frame. This is
     * essentially a JPanel with added capability to refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(_canvasImage, 0, 0, null);
        }
    }
}
