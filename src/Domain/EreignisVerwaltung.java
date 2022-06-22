package Domain;

import model.Ereignis;

import java.util.ArrayList;
import java.util.List;

public class EreignisVerwaltung {

  private   List<Ereignis> ereignis;



    public EreignisVerwaltung() {
        this.ereignis = new ArrayList<>();

    }

    public void KundenAuslagereungEreignissSpeicher(Ereignis ereignis) {

        this.ereignis.add(ereignis);

    }

    public void fuegeEreignisHinzu(Ereignis ereignis) {
       this.ereignis.add(ereignis);

    }

    public List<Ereignis> kundenEreigniss() {
        return ereignis;
    }




    public List<Ereignis> kundenValueEreignis(){
        return ereignis;
    }
}
