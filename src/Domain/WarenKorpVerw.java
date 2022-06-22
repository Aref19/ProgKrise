package Domain;

import exception.NotFoundEx;
import model.Artikel;
import model.Kunde;
import model.WarenKorp;

import java.util.HashMap;

public class WarenKorpVerw {

        WarenKorp waren;

        public WarenKorpVerw() {
          this.waren=  new WarenKorp();
        }

        public void addArtikel(Artikel artikel,int anzahl) {
            waren.addArtikle(artikel,anzahl);
        }

        public Boolean removeArtikel(Artikel artikel) {
            try {
                waren.loschArtikle(artikel);
                return true;
            } catch (NotFoundEx e) {
                e.printStackTrace();
                return false;
            }
        }

        public void leer(){
            waren.removeAll();
        }

        public void kaufen(Kunde kunde){

        }
        public HashMap<Artikel,Integer> getArtikelWarenK(Kunde kunde){
            return kunde.getWarenKorp().get();

    }

    }


