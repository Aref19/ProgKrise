package model;

import java.io.Serializable;


public class Mitarbeiter extends Person implements Serializable {
    /**
     * Mitarbeiter erweitert Person
     * <p>
     * Constructor
     *
     * @param mitarbeiterNr
     * @param mitarbeiterVorname
     * @param mitarbeiterNachName
     */

    public Mitarbeiter(int mitarbeiterNr, String mitarbeiterVorname, String mitarbeiterNachName, String pass) {
        super(mitarbeiterNr, mitarbeiterVorname, mitarbeiterNachName, pass);


        /**
         * Überschreiben, vom hash Code damit vom Mitarbeiter Vorname gegeben wird.
         * @return
         */


    }
}