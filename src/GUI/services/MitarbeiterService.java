package GUI.services;

import Domain.EshopVerwaltung;
import exception.EmailExisted;
import exception.INcorrectEmailException;
import exception.LoginFailedException;
import exception.RegisitierungException;
import model.*;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MitarbeiterService {
    EshopVerwaltung eschopverwaltung = new EshopVerwaltung();
    private DefaultTableModel defaultTableModel;
    Person mitarbeiter;

    /**
     * Anmelden Methode
     * Die Einloggen Informationen(Email und Passwort) werden von der
     * MitarbeiterVerwaltung durch eshopVerwaltung aufgerufen
     * Ansonsten wird ein Exception geworfen "Sie haben noch kein Account"
     * @param email
     * @param password
     * @throws LoginFailedException
     */
    public void anmelden(String email, String password) throws LoginFailedException {
        try {
            mitarbeiter = eschopverwaltung.mitarbeiterEinloggen(email, password).person;

        } catch (LoginFailedException e) {
            throw e;
        }
    }

    /**
     *
     * @param name
     * @param nachname
     * @param passwort
     * @param email
     * @return
     * @throws EmailExisted
     * @throws INcorrectEmailException
     */
    public boolean registrieren(String name, String nachname, String passwort, String email)
            throws EmailExisted, INcorrectEmailException {
        try {
            eschopverwaltung.mitarbeiterAnthorRegiseren(name, nachname, passwort, email);
            return true;
        } catch ( IOException e) {
            return false;
        }catch (INcorrectEmailException eI){
            throw eI;
        }catch (EmailExisted emailExisted){
            throw emailExisted;
        }
    }

    public DefaultTableModel putArtikel() {
        List<Artikel> artikels = eschopverwaltung.artielzeigen();
        return getDefaultTable(artikels);
    }

    public DefaultTableModel putArtikelSort(boolean sortieren) {
        List<Artikel> artikels = eschopverwaltung.artikelSortieren(sortieren);
        return getDefaultTable(artikels);
    }

    public void artikelLegen(Artikel artikel) throws IOException {
        eschopverwaltung.artikelAnlegen(((Mitarbeiter) mitarbeiter), artikel);
    }

    public DefaultTableModel putErignisse() {
        List<Ereignis> ereignis = eschopverwaltung.ereignissToSaveToEreigniss();
        return getDefaultTable(ereignis);
    }

    private String simpleFormat(Date date) {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("HH:mm dd.MM yyyy");
        return simpleFormatter.format(date);

    }

    public DefaultTableModel putErignisseSorted(int sort) {
        List<Ereignis> ereignis = eschopverwaltung.sortedErigmis(sort);
        return getDefaultTable(ereignis);
    }


    public DefaultTableModel ereignisFiltern(int filter, String data) {
        List<Ereignis> filterList = eschopverwaltung.ereignisFiltern(filter, data);
        return getDefaultTable(filterList);
    }

    private <T> DefaultTableModel getDefaultTable(List<T> list) {
        if(list.size()>0){
            if (list.get(0) instanceof Ereignis) {
                defaultTableModel = new DefaultTableModel();
                defaultTableModel.addColumn("Person");
                defaultTableModel.addColumn("Datum");
                defaultTableModel.addColumn("Artikel");
                defaultTableModel.addColumn("Menge");
                defaultTableModel.addColumn("Satus");
                for (T ereignis1 : list) {
                    String[] artikleArray = {((Ereignis) ereignis1).getPerson().getVorName(), simpleFormat(Date.from(((Ereignis) ereignis1).getDatum())),
                            ((Ereignis) ereignis1).getArtikel().getArtikelBezeichnung(), String.valueOf(((Ereignis) ereignis1).getArtikel().getArtikelBestand()),
                            ((Ereignis) ereignis1).getStatus().toString()};
                    defaultTableModel.addRow(artikleArray);

                }
            }
            if (list.get(0) instanceof  Artikel) {
                defaultTableModel = new DefaultTableModel();
                defaultTableModel.addColumn("name");
                defaultTableModel.addColumn("betsand");
                defaultTableModel.addColumn("preis");
                defaultTableModel.addColumn("Masse");
                for (T ar : list) {
                    int masse = ar instanceof Massengutartikel ? ((Massengutartikel) ar).getMasse() : 1;
                    if (((Artikel) ar).getArtikelBestand() != 0) {
                        String[] artikleArray = {((Artikel) ar).getArtikelBezeichnung(), String.valueOf(((Artikel) ar).getArtikelBestand()),
                                String.valueOf(((Artikel) ar).getPreis()), String.valueOf(masse)};
                        defaultTableModel.addRow(artikleArray);
                    }
                }
            }
        }else {
            defaultTableModel = new DefaultTableModel();
            defaultTableModel.addColumn("name");
            defaultTableModel.addColumn("betsand");
            defaultTableModel.addColumn("preis");
            defaultTableModel.addColumn("Masse");
        }
        return defaultTableModel;
    }
}
