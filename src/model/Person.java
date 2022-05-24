package model;

<<<<<<< HEAD
import java.io.Serializable;

public abstract class Person implements Serializable {
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
=======

public abstract class Person  {
    private int nummer;
    private String vorName;
    private String nachName;
    private String password;

    public Person(int nummer, String vorName, String nachName,String password) {
        this.nummer = nummer;
        this.vorName = vorName;
        this.nachName = nachName;
        this.password=password;
>>>>>>> 9d7b6d36315e18e3ea8291b81bae3b2be107e396
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

<<<<<<< HEAD
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }


=======
    public String getPassword(){
        return this.password;
    }

    public String toString() {
        String person=nachName+vorName;
        return
             person;
    }
>>>>>>> 9d7b6d36315e18e3ea8291b81bae3b2be107e396
}
