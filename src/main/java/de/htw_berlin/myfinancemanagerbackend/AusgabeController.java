package de.htw_berlin.myfinancemanagerbackend;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ausgaben")
@CrossOrigin(origins = "*")
public class AusgabeController {

    private final AusgabeRepository repository;

    public AusgabeController(AusgabeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Ausgabe> getAlle() {
        return repository.findAll();
    }

    @PostMapping
    public Ausgabe erstellen(@RequestBody Ausgabe ausgabe) {
        return repository.save(ausgabe);
    }
}