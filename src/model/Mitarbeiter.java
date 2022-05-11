package model;

public class Mitarbeiter {
    private int mitarbeiterNr;
    private String mitarbeiterName;
    private int mitarbeiterHausNr;
    private int mitarbeiterPlz;
    private String mitarbeiterStadt;
    private String mitarbeiterHerkunft;

    public Mitarbeiter(int mitarbeiterNr, String mitarbeiterName, int mitarbeiterHausNr, int mitarbeiterPlz, String mitarbeiterStadt, String mitarbeiterHerkunft){
        this.mitarbeiterNr = mitarbeiterNr;
        this.mitarbeiterName = mitarbeiterName;
        this.mitarbeiterHausNr = mitarbeiterHausNr;
        this.mitarbeiterPlz = mitarbeiterPlz;
        this.mitarbeiterStadt = mitarbeiterStadt;
        this.mitarbeiterHerkunft = mitarbeiterHerkunft;
    }

    public int getMitarbeiterNr() {
        return mitarbeiterNr;
    }

    public String getMitarbeiterName() {
        return mitarbeiterName;
    }

    public int getMitarbeiterHausNr() {
        return mitarbeiterHausNr;
    }

    public void setMitarbeiterHausNr(int mitarbeiterHausNr) {
        this.mitarbeiterHausNr = mitarbeiterHausNr;
    }
    public int getMitarbeiterPlz(){
        return mitarbeiterPlz;
    }

    public void setMitarbeiterPlz(int mitarbeiterPlz) {
        this.mitarbeiterPlz = mitarbeiterPlz;
    }
    public String getMitarbeiterStadt(){
        return mitarbeiterStadt;
    }
    public void setMitarbeiterStadt(String mitarbeiterStadt){
        this.mitarbeiterStadt = mitarbeiterStadt;
    }

    public String getMitarbeiterHerkunft() {
        return mitarbeiterHerkunft;
    }

}
