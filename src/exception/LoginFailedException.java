package exception;

import model.Kunde;

public class LoginFailedException extends Exception {

    public LoginFailedException() {
        super("Sie haben noch keinen Account");
    }
}
