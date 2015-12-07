/** Die Klasse Simulator.
 *
 */

public class Simulator
{
    public Parcour _parcour;
    public BildEinleser _bildEinleser;
    public Leinwand _leinwand;
    public Roboter _roboter;

    public Simulator()
    {
        _parcour = new Parcour();
        _roboter = new Roboter();
    }
}