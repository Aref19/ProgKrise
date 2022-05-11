package model;

public class Kunden {


    private int kundenNr;
    private String kundenName;
    private int kundenHausNr;
    private int kundenPlz;
    private String kundenStadt;
    private String kundenHerkunft;

    public Kunden(int kundenNr, String kundenName, int kundenHausNr, int kundenPlz, String kundenStadt, String kundenHerkunft){
        this.kundenNr = kundenNr;
        this.kundenName = kundenName;
        this.kundenHausNr = kundenHausNr;
        this.kundenPlz = kundenPlz;
        this.kundenStadt = kundenStadt;
        this.kundenHerkunft = kundenHerkunft;
    }

    public int getKundenNr() {
        return kundenNr;
    }

    public String getKundenName() {
        return kundenName;
    }

    public int getKundenHausNr() {
        return kundenHausNr;
    }

    public void setKundenHausNr(int kundenHausNr) {
        this.kundenHausNr = kundenHausNr;
    }

    public int getKundenPlz() {
        return kundenPlz;
    }
    public void setKundenPlz(int kundenPlz){
        this.kundenPlz = kundenPlz;
    }
}

