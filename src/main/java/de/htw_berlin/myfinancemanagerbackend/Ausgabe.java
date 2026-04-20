package de.htw_berlin.myfinancemanagerbackend;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity //Entität, Datenbanktabelle
public class Ausgabe {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primärschlüssel
    private Long id;
//Tabellenspalten
    private String titel;
    private double betrag;
    private String kategorie;
    private LocalDate datum;
//leerer Konstrukto für Spring um Objekte zu erstellen
    public Ausgabe() {}
//Konstruktor, speichert die Werte
    public Ausgabe(Long id, String titel, double betrag, String kategorie, LocalDate datum) {
        this.id = id;
        this.titel = titel;
        this.betrag = betrag;
        this.kategorie = kategorie;
        this.datum = datum;
    }

    // Getters zum auslesen
    public Long getId() { return id; }
    public String getTitel() { return titel; }
    public double getBetrag() { return betrag; }
    public String getKategorie() { return kategorie; }
    public LocalDate getDatum() { return datum; }
}
