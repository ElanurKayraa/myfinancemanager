package de.htw_berlin.myfinancemanagerbackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ausgaben")
@CrossOrigin(origins = "*")
public class AusgabeController {

    private final AusgabeRepository repository;

    public AusgabeController(AusgabeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Ausgabe>> getAlle(@RequestParam(required = false) Long profilId) {
        if (profilId != null) {
            return ResponseEntity.ok(repository.findByProfilId(profilId));
        }
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Ausgabe> erstellen(@RequestBody Ausgabe ausgabe) {
        Ausgabe gespeichert = repository.save(ausgabe);
        return ResponseEntity.status(HttpStatus.CREATED).body(gespeichert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ausgabe> bearbeiten(@PathVariable Long id, @RequestBody Ausgabe aktualisiert) {
        Optional<Ausgabe> vorhanden = repository.findById(id);

        if (vorhanden.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Ausgabe ausgabe = vorhanden.get();
        ausgabe.setTitel(aktualisiert.getTitel());
        ausgabe.setBetrag(aktualisiert.getBetrag());
        ausgabe.setKategorie(aktualisiert.getKategorie());
        ausgabe.setDatum(aktualisiert.getDatum());
        ausgabe.setTyp(aktualisiert.getTyp());

        return ResponseEntity.ok(repository.save(ausgabe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> loeschen(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
