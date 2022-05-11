package exception;

import java.io.IOException;

public class CustomIoException extends IOException {

    /**
     * First Option
     * @return
     * message unsere wahl
     */
    @Override
    public String getMessage() {
        return "Etwas ist Schief gelaufen";
    }

}
