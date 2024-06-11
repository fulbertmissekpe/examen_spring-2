package core.core.core.services;

import core.core.core.data.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    void save(Patient data);
    List<Patient> getAll();
}
