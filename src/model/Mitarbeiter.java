package model;

import java.io.Serializable;

public class Mitarbeiter extends Person implements Serializable {
    /**
     * Mitarbeiter erweitert Person
     *
     * Constructor
     * @param mitarbeiterNr
     * @param mitarbeiterVorname
     * @param mitarbeiterNachName
     * @param mitarbeiterPasswort
     */

    public Mitarbeiter(int mitarbeiterNr, String mitarbeiterVorname, String mitarbeiterNachName, String mitarbeiterPasswort){
        super(mitarbeiterNr, mitarbeiterVorname, mitarbeiterNachName , mitarbeiterPasswort);
    }

    /**
     * Überschreiben, vom hash Code damit vom Mitarbeiter Vorname gegeben wird.
     * @return
     */
    @Override
    public String toString() {
        return this.getVorName();
    }

}
