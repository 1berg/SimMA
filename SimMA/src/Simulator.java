/** Die Klasse Simulator.
 *
 */

public class Simulator
{
    public static Parcours _parcours;
    public static Roboter _roboter;
    public static BildEinleser _bildEinleser;

    public Simulator()
    {

    }

    public static void main(String[] args)
    {
        _bildEinleser = new BildEinleser();
        _parcours = new Parcours(); //Macht die Leinwand sichtbar
        _roboter = new Roboter(20 ,_parcours.gibBildhoehe() -50); //Erzeugt einen neuen Roboter
        _roboter.zeichnen();
         //TODO Roboter auf den Parcours bekommen.


    }
}