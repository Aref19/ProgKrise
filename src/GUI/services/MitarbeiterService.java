package GUI.services;

import Domain.EshopVerwaltung;
import exception.EmailExisted;
import exception.INcorrectEmailException;
import exception.LoginFailedException;
import exception.RegisitierungException;
import model.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MitarbeiterService {
    EshopVerwaltung eschopverwaltung = new EshopVerwaltung();
    private DefaultTableModel defaultTableModel;
    Person mitarbeiter;
    public void anmelden (String email, String password) throws LoginFailedException {
        try {
            mitarbeiter=eschopverwaltung.mitarbeiterEinloggen(email,password).person;
            System.out.println(mitarbeiter.getId());
        } catch (LoginFailedException e) {
            throw  e;
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

    public void artikelLegen(Artikel artikel) throws IOException {
        eschopverwaltung.artikelAnlegen(((Mitarbeiter) mitarbeiter),artikel);
    }

    public DefaultTableModel putErignisse(){
        List<Ereignis> ereignis = eschopverwaltung.ereignissToSaveToEreigniss();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Person");
        defaultTableModel.addColumn("Datum");
        defaultTableModel.addColumn("Artikel");
        defaultTableModel.addColumn("Menge");
        defaultTableModel.addColumn("Satus");
        for (Ereignis ereignis1 : ereignis) {
                String[] artikleArray = {ereignis1.getPerson().getVorName(),simpleFormat( Date.from(ereignis1.getDatum())),
                        ereignis1.getArtikel().getArtikelBezeichnung(),String.valueOf( ereignis1.getArtikel().getArtikelBestand()),
                ereignis1.getStatus().toString()};
                defaultTableModel.addRow(artikleArray);

        }
        return defaultTableModel;
    }

    private String simpleFormat(Date date){
        SimpleDateFormat simpleFormatter=new SimpleDateFormat("HH:mm dd.MM yyyy");
        return simpleFormatter.format(date);

    }

    public DefaultTableModel putErignisseSorted(int sort){
        List<Ereignis> ereignis = eschopverwaltung.sortedErigmis(sort);
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Person");
        defaultTableModel.addColumn("Datum");
        defaultTableModel.addColumn("Artikel");
        defaultTableModel.addColumn("Menge");
        defaultTableModel.addColumn("Satus");
        for (Ereignis ereignis1 : ereignis) {
            String[] artikleArray = {ereignis1.getPerson().getVorName(),simpleFormat( Date.from(ereignis1.getDatum())),
                    ereignis1.getArtikel().getArtikelBezeichnung(),String.valueOf( ereignis1.getArtikel().getArtikelBestand()),
                    ereignis1.getStatus().toString()};
            defaultTableModel.addRow(artikleArray);

        }
        return defaultTableModel;
    }



}
