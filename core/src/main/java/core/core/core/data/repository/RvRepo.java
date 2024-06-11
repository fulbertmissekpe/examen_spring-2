package core.core.core.data.repository;

import core.core.core.data.entities.Medecin;
import core.core.core.data.entities.Patient;
import core.core.core.data.entities.RV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RvRepo extends JpaRepository<RV,Long> {
    List<RV> findRVByActiveTrue();
    List<RV> findByDateHeureBetween(LocalDateTime start, LocalDateTime end);
    List<RV> findAllByPatientAndValideTrue(Patient patient);
   // List<RV> findByPatient(Patient patient);
    //List<RV> findByMedecin(Medecin medecin);

    RV findRvByDateHeure(LocalDateTime date);
}
