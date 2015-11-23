/**
 * Eine MotorPort Klasse, die die Implementierung für den simulierten MotorPort übernimmt.
 *
 */

public class MotorPort {

    static MotorPort A;
    static MotorPort B;
    static MotorPort C;

    public MotorPort(){

        A = new MotorPort();
        B = new MotorPort();
        C = new MotorPort();

    }

}