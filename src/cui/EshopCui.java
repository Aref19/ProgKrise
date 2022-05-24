package cui;
import Domain.*;

import Utilities.IO;
import exception.CustomIoException;
import model.*;

public class EshopCui {
    EshopVerwaltung eshopVerwaltung=new EshopVerwaltung();

    public static void main(String[] args) throws CustomIoException {
        EshopCui eshopCui=new EshopCui();


        do {
            System.out.println("1-> kund Registieren \n 2-> kund Einlogen\n3->mitarbeiter Registieren\n " +
                    "4-> mitarbeitEilogen \n "
                     );
            int s=IO.inputInt();
            switch (s) {

                case 1 -> {
                    eshopCui.kundRegestieren();
                }
                case 2 -> {
                    if (eshopCui.kundEilogen()) {
                        System.out.println("jetzt legen sie Artikel in WarenKorb");
                        eshopCui.warenEinlegen();
                        System.out.println("wollen sie kaufen j/n");
                        String ein=IO.inputString();
                        if(ein.equals("j")){
                            eshopCui.warenkaufen();
                            System.out.println("das ist Ihre Rechnung : \n");
                            System.out.println("der Ereignis");

                        }else
                            System.out.println("shön das sie da war");
                    }
                }
                case 3 -> {
                    eshopCui.mitarbeiterRegis();
                }
                case 4 -> {
                    if(  eshopCui.mitarbeiterEilogen()){
                        System.out.println("wollen sie was 1-> Mitarbeiter Reguísteren 2->Eilagerung");
                        switch (IO.inputInt()){
                            case 1->{
                                eshopCui.mitarbeiterRegisanther();
                            }
                            case 2->{
                                eshopCui.eilagerung();
                            }
                        }
                    }
                }
            }
            System.out.println("wollen sie beenden n/j");
        }while (IO.inputString().equals("n"));

    }

    public  void kundRegestieren(){
        System.out.println("giben sie name");
        String name  = IO.inputString();
        System.out.println("geben nach name");
        String namchname  = IO.inputString();
        System.out.println("geben sie hasnummer");
        int hausnumm  = IO.inputInt();
        System.out.println("geben sie plz");
        int plz = IO.inputInt();
        System.out.println("geben sie Stadt");
        String stadt = IO.inputString();
        System.out.println("geben sie pass");
        String pass = IO.inputString();
        eshopVerwaltung.kundRegistieren( new Kunden(1,name,namchname,new Adresse(hausnumm,plz,stadt),pass));
    }
    public boolean kundEilogen(){
        System.out.println("giben sie name");
        String name  = IO.inputString();
        System.out.println("giben sie name");
        String pass  = IO.inputString();
        return eshopVerwaltung.kundAnlogen(name,pass);

    }

    public void mitarbeiterRegis() throws CustomIoException {
        System.out.println("giben sie name");
        String name  = IO.inputString();
        System.out.println("geben nach name");
        String namchname  = IO.inputString();
        System.out.println("geben sie pass");
        String pass = IO.inputString();
        eshopVerwaltung.mitarbeiterRe(new Mitarbeiter(2,name,namchname,pass));
    }

    public boolean mitarbeiterEilogen() throws CustomIoException {
        System.out.println("giben sie name");
        String name  = IO.inputString();
        System.out.println("giben sie pass");
        String pass = IO.inputString();
      return  eshopVerwaltung.mitarbeiterEilogen(name,pass);
    }

    public void warenEinlegen(){
        System.out.println("giben sie name");
        String name  = IO.inputString();
        System.out.println("geben sie anzah");
        int hausnumm  = IO.inputInt();
        eshopVerwaltung.warenlegen(new Artikel(1,name,hausnumm,2.5));

    }

    public  void  warenkaufen(){
        eshopVerwaltung.kaufen();
    }

    public void eilagerung(){
        System.out.println(" name Artikel :");
        String na=IO.inputString();
        System.out.println(" bestand Artikel :");
        int be=IO.inputInt();
        System.out.println(" preis Artikel :");
        double pr=IO.inputdoubel();
       Ereigniss ereigniss= eshopVerwaltung.eilage(new Artikel(2,na,be,pr));
        System.out.println(ereigniss);
    }

    public void mitarbeiterRegisanther() throws CustomIoException {
        System.out.println("giben sie name");
        String name  = IO.inputString();
        System.out.println("geben nach name");
        String namchname  = IO.inputString();
        System.out.println("geben sie pass");
        String pass = IO.inputString();
        eshopVerwaltung.mitarbeiteranthorReg(new Mitarbeiter(1,name,namchname,pass));

    }
    public void kundEreignis(String na,int be){
     Ereigniss ereigniss=   eshopVerwaltung.ergnissKund(new Artikel(1,na,be,2.5));
        System.out.println(ereigniss);
    }



}
