package model;

import java.io.Serializable;

<<<<<<< HEAD
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
=======
    public Mitarbeiter(int mitarbeiterNr, String mitarbeiterVorname, String mitarbeiterNachName,String pass){
        super(mitarbeiterNr, mitarbeiterVorname, mitarbeiterNachName,pass);
>>>>>>> 9d7b6d36315e18e3ea8291b81bae3b2be107e396

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
