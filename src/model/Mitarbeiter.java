package model;

import java.io.Serializable;


public class Mitarbeiter extends Person implements Serializable {
    /**
     * Mitarbeiter erweitert Person
     * <p>
     * Constructor
     *
     * @param mitarbeiterVorname
     * @param mitarbeiterNachName
     */

    public Mitarbeiter( String mitarbeiterVorname, String mitarbeiterNachName, String pass,String email) {
        super( mitarbeiterVorname, mitarbeiterNachName, pass,email);


        /**
         * Überschreiben, vom hash Code damit vom Mitarbeiter Vorname gegeben wird.
         * @return
         */


    }
}