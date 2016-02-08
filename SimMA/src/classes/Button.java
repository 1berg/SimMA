package classes;

/**
 * Die Klasse classes.Button simuliert das Verhalten des Enter- und Escape-Buttons am NXT-Brick.
 *
 * Created by Pamina on 21.12.15.
 */
public class Button extends Object
{
    public static Button ENTER = new Button();
    public static Button ESCAPE = new Button();

    public Button()
    {
    }

    /**
     * Überprüft, ob der ausgewählte classes.Button gedrückt wurde.
     * @return
     */
    public final boolean isPressed()
    {
        return false;
    }
}
