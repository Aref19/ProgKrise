package model;



public abstract class Person  {
    /**
     * Variable der Klasse Person
     */
    private int nummer;
    private String vorName;
    private String nachName;
    private String passwort;

    /**
     * Constructor
     * @param nummer
     * @param vorName
     * @param nachName
     * @param passwort
     */
    public Person(int nummer, String vorName, String nachName, String passwort) {
        this.nummer = nummer;
        this.vorName = vorName;
        this.nachName = nachName;
        this.passwort = passwort;

    }

    /**
     * Getter und Setter
     * @return
     */
    public int getNummer() {
        return nummer;
    }

    public String getVorName() {
        return vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }


    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }



    public String getPassword(){
        return this.passwort;
    }

    public String toString() {
        String person=nachName+vorName;
        return
             person;
    }

}
