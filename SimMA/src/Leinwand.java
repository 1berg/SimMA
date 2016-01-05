import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

/**
 * Die Klasse Leinwand erlaubt einfache grafische Operationen auf einer Leinwand.
 *
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

    /**
     * Erzeuge eine Leinwand mit einem (weissen) Standardhintergrund.
     *
     * @param title
     *            title to appear in Canvas Frame
     * @param width
     *            the desired width for the canvas
     * @param height
     *            the desired height for the canvas
     */
    public Leinwand(String title, int width, int height)
    {
        this(title, width, height, Color.white);
    }

    /**
     * Erzeuge eine Leinwand.
     *
     * @param title
     *            title to appear in Canvas Frame
     * @param width
     *            the desired width for the canvas
     * @param height
     *            the desired height for the canvas
     * @param bgColour
     *            the desired background colour of the canvas
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
            // first time: instantiate the offscreen image and fill it with
            // the background colour
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
     * Zeichne ein Bild, das in unserem internen Format angegeben ist (ein zweidimensionales Array
     * von Grauwerten als short-Werte).
     */
    public void zeichneBild(short[][] bild)
    {
        int height = bild.length;
        int width = bild[0].length;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
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
     * Draws an image onto the canvas.
     *
     * @param image
     *            the Image object to be displayed
     * @param x
     *            x co-ordinate for Image placement
     * @param y
     *            y co-ordinate for Image placement
     * @return returns boolean value representing whether the image was completely loaded
     */
    private boolean drawImage(Image image, int x, int y) //Image in Obejct geändert, public statt private
    {
        boolean result = _graphic.drawImage(image, x, y, null);
        _canvas.repaint();
        return result;
    }

    /**
     * Zeichne fuer das gegebene Figur-Objekt eine Java-Figur (einen Shape) auf
     * die Leinwand.
     *
     * @param figur
     *            das Figur-Objekt, fuer das ein Shape gezeichnet werden soll
     * @param farbe
     *            die Farbe der Figur
     * @param shape
     *            ein Objekt der Klasse Shape, das tatsaechlich gezeichnet wird
     */
    public void zeichne(Object figur, String farbe, Shape shape)
    {
        ShapeMitFarbe shapeMitFarbe = new ShapeMitFarbe(shape, farbe);

            shapeMitFarbe.draw(_graphic);
    }

    /**
     * Interne Klasse ShapeMitFarbe - Da die Klasse Shape des JDK nicht auch
     * eine Farbe mitverwalten kann, muss mit dieser Klasse die Verknuepfung
     * modelliert werden.
     */
    private class ShapeMitFarbe
    {
        private Shape shape;
        private String farbe;

        public ShapeMitFarbe(Shape shape, String farbe)
        {
            this.shape = shape;
            this.farbe = farbe;
        }

        public void draw(Graphics2D graphic)
        {
            graphic.fill(shape);
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
