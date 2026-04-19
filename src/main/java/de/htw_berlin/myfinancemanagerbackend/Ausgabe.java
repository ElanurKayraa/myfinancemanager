package de.htw_berlin.myfinancemanagerbackend;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Ausgabe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titel;
    private double betrag;
    private String kategorie;
    private LocalDate datum;

    public Ausgabe() {}

    public Ausgabe(Long id, String titel, double betrag, String kategorie, LocalDate datum) {
        this.id = id;
        this.titel = titel;
        this.betrag = betrag;
        this.kategorie = kategorie;
        this.datum = datum;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitel() { return titel; }
    public double getBetrag() { return betrag; }
    public String getKategorie() { return kategorie; }
    public LocalDate getDatum() { return datum; }
}