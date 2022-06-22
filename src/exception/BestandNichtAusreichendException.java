package exception;

import model.Artikel;

public class BestandNichtAusreichendException extends Exception {

    public BestandNichtAusreichendException(Artikel artikel) {
        super("Der Bestand von Artikel " + artikel.getArtikelBezeichnung()
                + " betraegt nur " + artikel.getArtikelBestand() + " Stueck.");
    }
}
