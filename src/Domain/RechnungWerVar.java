package Domain;

import model.Artikel;
import model.Kunden;
import model.Rechnung;

import java.util.HashMap;

public class RechnungWerVar {
    Rechnung rechnung;
    public RechnungWerVar() {

    }

    public Rechnung creatRec(Kunden kunden, HashMap<Artikel,Integer> artikels){
        return new Rechnung(kunden,artikels);
    }
}
