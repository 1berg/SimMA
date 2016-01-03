/**
 * Die Klasse Button simuliert das Verhalten des Enter- und Escape-Buttons am NXT-Brick.
 *
 * Created by Pamina on 21.12.15.
 */
public class Button extends Object
{
    public static Button ENTER;
    public static Button ESCAPE;

    public Button()
    {
        ENTER = new Button();
        ESCAPE = new Button();

    }

    /**
     * Überprüft, ob der ausgewählte Button gedrückt wurde.
     * @return
     */
    public final boolean isPressed()
    {
        return false; //TODO Implementation des Buttons als Listener im Extension-Interface muss hier noch eingefügt werden
    }
}
