package core.core.core.data.repository;

import core.core.core.data.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepo extends JpaRepository<Medecin,Long> {
    List<Medecin> findMedecinByActiveTrue();
    Medecin findById(int id);
}
