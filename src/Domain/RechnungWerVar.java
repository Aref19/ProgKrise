package Domain;

import model.Artikel;
import model.Kunde;
import model.Rechnung;

import java.util.HashMap;

public class RechnungWerVar {
    Rechnung rechnung;
    public RechnungWerVar() {

    }

    public Rechnung creatRec(Kunde kunde, HashMap<Artikel,Integer> artikels){
        return new Rechnung(kunde,artikels);
    }
}
