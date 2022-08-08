package model;


import exception.INcorrectEmailException;

import java.io.Serializable;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person implements Serializable {

    private UUID id;
    private String vorName;
    private String nachName;
    private String passwort;
    private String email;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Constructor
     *
     * @param vorName
     * @param nachName
     * @param passwort
     */
    public Person( String vorName, String nachName, String passwort,String email) {
        this.id=UUID.randomUUID();
        this.vorName = vorName;
        this.nachName = nachName;
        this.passwort = passwort;
        this.email=email;
    }

    public Person(UUID id, String vorName, String nachName, String passwort,String email) {
        this.id=id;
        this.vorName = vorName;
        this.nachName = nachName;
        this.passwort = passwort;
        this.email=email;
    }

    /**
     * Getter und Setter
     *
     * @return
     */
    public UUID getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    public String getPassword() {
        return this.passwort;
    }



    public static boolean checkEmail(String emailStr)throws INcorrectEmailException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        if(!matcher.find()){
            throw new INcorrectEmailException();
        }
        return matcher.find();
    }

    public String toString() {
        String person = id.toString() + ";" +  vorName + ";" + nachName + ";" + passwort+";"+email;
        return person;
    }

}
