package de.htw_berlin.myfinancemanagerbackend;

import jakarta.persistence.*;

@Entity
public class Benutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String benutzername;

    @Column(nullable = false)
    private String passwort;

    public Benutzer() {}

    public Benutzer(Long id, String benutzername, String passwort) {
        this.id = id;
        this.benutzername = benutzername;
        this.passwort = passwort;
    }

    public Long getId() { return id; }
    public String getBenutzername() { return benutzername; }
    public String getPasswort() { return passwort; }
    public void setBenutzername(String benutzername) { this.benutzername = benutzername; }
    public void setPasswort(String passwort) { this.passwort = passwort; }
}
