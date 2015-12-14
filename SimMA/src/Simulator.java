/** Die Klasse Simulator.
 *
 */

public class Simulator
{
    public Parcours _parcours;
    public BildEinleser _bildEinleser;
    public Leinwand _leinwand;
    public Roboter _roboter;

    public Simulator()
    {
        _parcours = new Parcours();
        _roboter = new Roboter();
    }
}