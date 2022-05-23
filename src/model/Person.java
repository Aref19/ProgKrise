package model;


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
    }

    public int getNummer() {
        return nummer;
    }

    public String getVorName() {
        return vorName;
    }

    public String getNachName() {
        return nachName;
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

    public String getPassword(){
        return this.password;
    }

    public String toString() {
        String person=nachName+vorName;
        return
             person;
    }
}
