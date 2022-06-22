package Domain;

import model.Artikel;
import model.Ereignis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EreignisVerwaltung {

  private   List<Ereignis> kundenEreigniss;
   private List<Ereignis> mitarbeiterEreigniss;


    public EreignisVerwaltung() {
        this.kundenEreigniss = new ArrayList<>();
        this.mitarbeiterEreigniss = new ArrayList<>();
    }

    public void KundenAuslagereungEreignissSpeicher(Ereignis ereignis) {

        kundenEreigniss.add(ereignis);

    }

    public void mitarbeiterAuslagereungEreignissSpeicher(Ereignis ereignis) {
        mitarbeiterEreigniss.add(ereignis);
    }

    public List<Ereignis> kundenEreigniss() {
        return kundenEreigniss;
    }



    public List<Ereignis> mitarbeiterEreignis() {
        return mitarbeiterEreigniss;
    }

    public List<Ereignis> mitarbeiterValueEreignis(){
        return mitarbeiterEreigniss;
    }

    public List<Ereignis> kundenValueEreignis(){
        return kundenEreigniss;
    }
}
