package de.htw_berlin.myfinancemanagerbackend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AusgabeRepository extends JpaRepository<Ausgabe, Long> {
}