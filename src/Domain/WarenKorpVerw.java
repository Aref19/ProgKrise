package Domain;

import exception.NotFoundEx;
import model.Artikel;
import model.Kunden;
import model.WarenKorp;

import exception.NotFoundEx;
import model.Artikel;
import model.Kunden;
import model.WarenKorp;

public class WarenKorpVerw {

        WarenKorp warenKorp;

        public WarenKorpVerw() {
            warenKorp = new WarenKorp();
        }

        public void addArtikel(Artikel artikel) {
            warenKorp.addArtikle(artikel);
        }

        public Boolean removeArtikel(Artikel artikel) {
            try {
                warenKorp.loschArtikle(artikel);
                return true;
            } catch (NotFoundEx e) {
                e.printStackTrace();
                return false;
            }
        }

        public void leer(){
            warenKorp.removeAll();
        }

        public void kaufen(Kunden kunden){
            System.out.println( warenKorp.kaufen(kunden));

        }


    }


