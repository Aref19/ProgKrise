package cui;
import Domain.EshopVerwaltung;
import Domain.KundenVerwaltung;
import exception.ExistenceName;
import model.Adresse;
import model.Kunden;

public class EshopCui {
    public static void main(String[] args) {
        EshopVerwaltung eshopVerwaltung=new EshopVerwaltung();
        eshopVerwaltung.artikelSortieren();
        Kunden kunden=new Kunden(1,"ajab","o",new Adresse(12,2,"",""),"d");
        eshopVerwaltung.kundRegistieren(kunden);
        eshopVerwaltung.kundAnlogen("ajab","d");
        eshopVerwaltung.warenlegen();
        eshopVerwaltung.kaufen();

    }



}
