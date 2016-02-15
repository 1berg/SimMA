package simma.sim;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

/**
 * Eine Klasse zum Einlesen von Bilddaten.
 */
class BildEinleser
{
    private static JFrame _frame = null;
    private static JFileChooser _fileChooser = null;

    /**
     * Lies eine GIF-Datei ein und liefere die Bilddaten als Array. Die Datei wird interaktiv vom
     * Benutzer gewählt.
     */
    public static short[][] liesBilddaten()
    {

        if (_fileChooser == null)
        {
            _fileChooser = new JFileChooser("select a picture");
            _frame = new JFrame();
            _frame.pack();
            _frame.setAlwaysOnTop(true);
        }

        int returnVal = _fileChooser.showOpenDialog(_frame);

        if (returnVal != JFileChooser.APPROVE_OPTION)
        {
            return null;
        }

        String fileName = _fileChooser.getSelectedFile().getPath();
        Image image = new ImageIcon(fileName).getImage();
        BufferedImage bimage = toBufferedImage(image);

        return toByteArray(bimage);

    }


    /**
     * Hilfsklasse, um ein Image in ein BufferedImage umzuwandeln, da die Klasse Image dies nicht anbietet
     * @param image
     * @return
     *      Das übergebene image als BufferedImage
     */
    private static BufferedImage toBufferedImage(Image image)
    {

        image = new ImageIcon(image).getImage();

        // Ein BufferedImage erzeugen
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
                image.getHeight(null), BufferedImage.TYPE_INT_RGB);

        // Bild auf bufferedImage kopieren
        Graphics g = bufferedImage.createGraphics();

        // Bild zeichnen
        g.setColor(Color.white);
        g.fillRect(0, 0, image.getWidth(null), image.getHeight(null));
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return bufferedImage;
    }

    /**
     * Wandelt das BufferedImage in ein Array aus Bilddaten um
     * @param image
     * @return
     *      Das short-Array aus Bildpunkten
     *
     */
    private static short[][] toByteArray(BufferedImage image)
    {
        Raster raster = image.getData();
        int breite = raster.getWidth();
        int hoehe = raster.getHeight();

        short[][] bytes = new short[hoehe][breite];

        int[] intarr = new int[3]; // rgb values
        for (int y = 0; y < hoehe; y++)
        {
            for (int x = 0; x < breite; x++)
            {
                raster.getPixel(x, y, intarr);
                bytes[y][x] = (short) ((intarr[0] + intarr[1] + intarr[2]) / 3);
            }
        }
        return bytes;
    }

}
