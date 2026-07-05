package de.htw_berlin.myfinancemanagerbackend;

import jakarta.persistence.*;

@Entity
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long benutzerId;

    public Profil() {}

    public Profil(Long id, String name, Long benutzerId) {
        this.id = id;
        this.name = name;
        this.benutzerId = benutzerId;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Long getBenutzerId() { return benutzerId; }
    public void setName(String name) { this.name = name; }
    public void setBenutzerId(Long benutzerId) { this.benutzerId = benutzerId; }
}
