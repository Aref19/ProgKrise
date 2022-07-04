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


    public String getMessage2(){
        return "Es ist leider was Schiefgelaufen";
    }
    public String getMessage3(){
        return  "Dieses Person ist bereits Vorhanden";
    }
}
