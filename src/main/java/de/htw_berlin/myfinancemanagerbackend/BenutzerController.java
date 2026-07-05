package de.htw_berlin.myfinancemanagerbackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/benutzer")
@CrossOrigin(origins = "*")
public class BenutzerController {

    private final BenutzerRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public BenutzerController(BenutzerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/registrieren")
    public ResponseEntity<?> registrieren(@RequestBody Benutzer benutzer) {
        if (benutzer.getBenutzername() == null || benutzer.getBenutzername().isBlank()
                || benutzer.getPasswort() == null || benutzer.getPasswort().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("fehler", "Benutzername und Passwort dürfen nicht leer sein."));
        }

        if (repository.findByBenutzername(benutzer.getBenutzername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("fehler", "Benutzername ist bereits vergeben."));
        }

        benutzer.setPasswort(passwordEncoder.encode(benutzer.getPasswort()));
        Benutzer gespeichert = repository.save(benutzer);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("id", gespeichert.getId(), "benutzername", gespeichert.getBenutzername()));
    }

    @PostMapping("/anmelden")
    public ResponseEntity<?> anmelden(@RequestBody Benutzer login) {
        Optional<Benutzer> gefunden = repository.findByBenutzername(login.getBenutzername());

        if (gefunden.isEmpty() || !passwordEncoder.matches(login.getPasswort(), gefunden.get().getPasswort())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("fehler", "Benutzername oder Passwort ist falsch."));
        }

        Benutzer benutzer = gefunden.get();
        return ResponseEntity.ok(Map.of("id", benutzer.getId(), "benutzername", benutzer.getBenutzername()));
    }
}
