package de.htw_berlin.myfinancemanagerbackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*")
public class ProfilController {

    private final ProfilRepository repository;

    public ProfilController(ProfilRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Profil>> getProfileFuerBenutzer(@RequestParam Long benutzerId) {
        return ResponseEntity.ok(repository.findByBenutzerId(benutzerId));
    }

    @PostMapping
    public ResponseEntity<?> erstellen(@RequestBody Profil profil) {
        if (profil.getName() == null || profil.getName().isBlank() || profil.getBenutzerId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("fehler", "Name und Benutzer-ID werden benötigt."));
        }
        Profil gespeichert = repository.save(profil);
        return ResponseEntity.status(HttpStatus.CREATED).body(gespeichert);
    }
}
