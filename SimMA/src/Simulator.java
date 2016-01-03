/** Die Klasse Simulator.
 *
 */

public class Simulator
{
    public static Parcours _parcours;
    public static BildEinleser _bildEinleser;
    public static Leinwand _leinwand;
    public static Roboter _roboter;

    public Simulator()
    {

    }

    public static void main(String[] args)
    {
        _bildEinleser = new BildEinleser(); //Öffnet Dialog zur Auswahl des Parcours
        _parcours = new Parcours(); //Macht die Leinwand sichtbar
        _roboter = new Roboter(); //Erzeugt einen neuen Roboter

        _roboter.gibRoboter().zeichnen(); //TODO Roboter auf den Parcours bekommen.
        


    }
}