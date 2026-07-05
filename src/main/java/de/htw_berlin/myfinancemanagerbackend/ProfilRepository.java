package de.htw_berlin.myfinancemanagerbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfilRepository extends JpaRepository<Profil, Long> {
    List<Profil> findByBenutzerId(Long benutzerId);
}
