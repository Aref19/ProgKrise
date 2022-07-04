package Domain;

import model.Artikel;
import model.Kunde;
import model.Rechnung;

import java.util.HashMap;

public class RechnungWarenkorb {
    Rechnung rechnung;
    public RechnungWarenkorb() {

    }
    public Rechnung creatRec(Kunde kunde, HashMap<Artikel,Integer> artikels){
        return new Rechnung(kunde,artikels);
    }
}
