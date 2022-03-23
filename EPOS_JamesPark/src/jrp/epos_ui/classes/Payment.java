package jrp.epos_ui.classes;

/**
 * @author James Park
 */
@SuppressWarnings("unchecked")
public class Payment {

    private static boolean PIN_SUCCESSFULL = false;

    public static boolean isPIN_SUCCESSFULL() {
        return PIN_SUCCESSFULL;
    }

    public static void setPIN_SUCCESSFULL(boolean PIN_SUCCESSFULL) {
        Payment.PIN_SUCCESSFULL = PIN_SUCCESSFULL;
    }
}
