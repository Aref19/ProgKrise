package Domain;

import model.Ereignis;

import java.util.ArrayList;
import java.util.List;

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

    public void fuegeEreignisHinzu(Ereignis ereignis) {
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
