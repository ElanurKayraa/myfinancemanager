package de.htw_berlin.myfinancemanagerbackend;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController              //verbindet frontend und backend (HTTML -> JSON)
@RequestMapping("/ausgaben") //alle Routen in diesre KLasse sind erreichbar unter /ausgaben
public class AusgabeController {

    @GetMapping                     //reagiertv auf Get Anfragen  (Browesraufrufe)
    public List<Ausgabe> getAlle() { //Liste von Ausgabe-Objekten
        return List.of(        //erstellt feste Liste mit 2 Beispeil Daten
                new Ausgabe(1L, "Supermarkt", 42.50, "Lebensmittel", LocalDate.now()),
                new Ausgabe(2L, "Netflix", 12.99, "Freizeit", LocalDate.now())
        );
    }
}
