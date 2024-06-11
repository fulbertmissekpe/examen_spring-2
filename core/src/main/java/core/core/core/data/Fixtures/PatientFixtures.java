package core.core.core.data.Fixtures;

//@Component

import core.core.core.data.entities.AppRole;
import core.core.core.data.entities.Medecin;
import core.core.core.data.entities.Patient;
import core.core.core.data.enums.Specialite;
import core.core.core.data.repository.AppRoleRepository;
import core.core.core.services.PatientService;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
//@Component
@Order(4)
public class PatientFixtures implements CommandLineRunner {
    private final PatientService patient;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;
    List<AppRole> role=new ArrayList<>();
    @Override
    public void run(String... args) throws Exception {
        role.add(appRoleRepository.findAllById(2));
        for (int i = 1; i < 10; i++) {

                Patient salle=new Patient();
                salle.setNom("PATIENT"+i);
                salle.setPassword(passwordEncoder.encode("passer"));
                salle.setPrenom("prenom"+i);
                salle.setUsername("PATIENT"+i);
                salle.setRoles(role);
                salle.setMat("MAT"+i);
                salle.setActive(true);
                salle.setMontype("PATIENT");
                patient.save(salle);

        }
    }
}
