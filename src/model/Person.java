package model;

public abstract class Person  {
    private int nummer;
    private String vorName;
    private String nachName;

    public Person(int nummer, String vorName, String nachName) {
        this.nummer = nummer;
        this.vorName = vorName;
        this.nachName = nachName;
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
}
