package core.core.core.services.impl;

import core.core.core.data.entities.Patient;
import core.core.core.data.repository.PatientRepo;
import core.core.core.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepo   patientRepo;

    @Override
    public void save(Patient data) {
        patientRepo.save(data);
    }

    @Override
    public List<Patient> getAll() {
        return patientRepo.findPatientByActiveTrue();
    }


}
