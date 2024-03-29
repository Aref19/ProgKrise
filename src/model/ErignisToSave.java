package model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.UUID;

public class ErignisToSave implements Serializable {

    private UUID artikelNummer;
    private UUID mitarbeiterNummer;
    private  int anzahl;
    private Ereignis.STATUS status;
    Instant datum;
    private int serialNummer=1000;

    public ErignisToSave(UUID personId, UUID artikelNummer, Instant datum, Ereignis.STATUS status, int anzahl) {
        this.datum=datum;
        this.status=status;
        this.anzahl=anzahl;
        this.artikelNummer=artikelNummer;
        this.mitarbeiterNummer=personId;

    }

    public UUID getArtikelNummer() {
        return artikelNummer;
    }

    public void setArtikelNummer(UUID artikelNummer) {
        this.artikelNummer = artikelNummer;
    }

    public UUID personId() {
        return mitarbeiterNummer;
    }

    public void setMitarbeiterNummer(UUID mitarbeiterNummer) {
        this.mitarbeiterNummer = mitarbeiterNummer;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public Ereignis.STATUS getStatus() {
        return status;
    }

    public void setStatus(Ereignis.STATUS status) {
        this.status = status;
    }

    public Instant getDatum() {
        return datum;
    }

    public void setDatum(Instant datum) {
        this.datum = datum;
    }

    public int getSerialNummer() {
        return serialNummer;
    }

    public void setSerialNummer(int serialNummer) {
        this.serialNummer = serialNummer;
    }

    @Override
    public String toString(){
        return datum+";"+mitarbeiterNummer+";"+artikelNummer+";"+anzahl+";"+status;
    }

    public static Instant convertStringToInstat(String time){
        Instant result = Instant.parse(time);
        return result;
    }

    public static Ereignis.STATUS   statusFromString(String status){
        if(status.equals("Neu")){
            return Ereignis.STATUS.Neu;
        }else if(status.equals("Einlagerung")){
            return Ereignis.STATUS.Einlagerung;
        }else if(status.equals("Kauf")){
            return Ereignis.STATUS.Kauf;
        }else
            return Ereignis.STATUS.Auslagerung;
    }

}
