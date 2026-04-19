package de.htw_berlin.myfinancemanagerbackend;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ausgaben")
public class AusgabeController {

    @GetMapping
    public List<Ausgabe> getAlle() {
        return List.of(
                new Ausgabe(1L, "Supermarkt", 42.50, "Lebensmittel", LocalDate.now()),
                new Ausgabe(2L, "Netflix", 12.99, "Freizeit", LocalDate.now())
        );
    }
}