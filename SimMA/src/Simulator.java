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
        _bildEinleser = new BildEinleser();
        _leinwand = new Leinwand("Parcours 1", 400, 680);
        _parcours = new Parcours();
        _roboter = new Roboter();

        _bildEinleser.liesBilddaten();

    }
}