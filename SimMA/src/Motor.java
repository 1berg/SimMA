import lejos.nxt.MotorPort;

/**
 * Die Klasse Motor, die drei NXTRegulatedMotor-Felder enthält.
 */


public class Motor
        {
                public static final NXTRegulatedMotor A = new NXTRegulatedMotor(MotorPort.A);
                public static final NXTRegulatedMotor B = new NXTRegulatedMotor(MotorPort.B);
                public static final NXTRegulatedMotor C = new NXTRegulatedMotor(MotorPort.C);

            public Motor(){


            }
        }

