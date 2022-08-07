package GUI.services;

import Domain.EshopVerwaltung;
import exception.EmailExisted;
import exception.INcorrectEmailException;
import exception.LoginFailedException;
import exception.RegisitierungException;
import model.Artikel;
import model.Massengutartikel;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.List;

public class MitarbeiterService {
    EshopVerwaltung eschopverwaltung = new EshopVerwaltung();
    private DefaultTableModel defaultTableModel;
    public boolean anmelden (String email, String password){
        try {
            eschopverwaltung.mitarbeiterEinloggen(email,password);
            return true;
        } catch (LoginFailedException e) {
            return false;
        }
    }
    public boolean registrieren(String name, String nachname, String passwort, String email)
            throws EmailExisted, INcorrectEmailException {
        try {
            eschopverwaltung.mitarbeiterAnthorRegiseren(name,nachname, passwort, email );
            return true;
        } catch (RegisitierungException | IOException e) {
            return false;
        }
    }

    public DefaultTableModel putArtikel() {
        List<Artikel> artikels = eschopverwaltung.artielzeigen();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("name");
        defaultTableModel.addColumn("betsand");
        defaultTableModel.addColumn("preis");
        defaultTableModel.addColumn("Masse");
        for (Artikel ar : artikels) {
            int masse = ar instanceof Massengutartikel ? ((Massengutartikel) ar).getMasse() : 1;
            if (ar.getArtikelBestand() != 0) {
                String[] artikleArray = {ar.getArtikelBezeichnung(), String.valueOf(ar.getArtikelBestand()), String.valueOf(ar.getPreis()), String.valueOf(masse)};
                defaultTableModel.addRow(artikleArray);
            }
        }
        return defaultTableModel;
    }

    public DefaultTableModel putArtikelSort(boolean sortieren) {
        List<Artikel> artikels = eschopverwaltung.artikelSortieren(sortieren);
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("name");
        defaultTableModel.addColumn("betsand");
        defaultTableModel.addColumn("preis");
        defaultTableModel.addColumn("Masse");
        for (Artikel ar : artikels) {
            int masse = ar instanceof Massengutartikel ? ((Massengutartikel) ar).getMasse() : 1;
            if (ar.getArtikelBestand() != 0) {
                String[] artikleArray = {ar.getArtikelBezeichnung(), String.valueOf(ar.getArtikelBestand()), String.valueOf(ar.getPreis()), String.valueOf(masse)};
                defaultTableModel.addRow(artikleArray);
            }
        }
        return defaultTableModel;
    }




}
