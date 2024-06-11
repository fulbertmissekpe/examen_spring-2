package core.core.core.data.repository;

import core.core.core.data.entities.Medecin;
import core.core.core.data.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    List<Patient> findPatientByActiveTrue();
    Patient findById(int id);
    Patient findByUsername(String name);

}
