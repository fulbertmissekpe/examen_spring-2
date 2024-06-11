package core.core.core.data.Fixtures;

import core.core.core.data.entities.AppRole;
import core.core.core.data.entities.Medecin;
import core.core.core.data.enums.Specialite;
import core.core.core.data.repository.AppRoleRepository;
import core.core.core.data.repository.AppUserRepository;
import core.core.core.services.MedecinService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
//@Component
@Order(3)
public class MedecinFixtures implements CommandLineRunner {
    private final MedecinService medecin;
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;

    List<AppRole> role=new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        role.add(appRoleRepository.findAllById(1));
        for (int i = 1; i < 10; i++) {
                Medecin salle=new Medecin();
                salle.setNom("MEDECIN"+i);
                salle.setPassword(passwordEncoder.encode("passer"));
                salle.setPrenom("prenom"+i);
                salle.setUsername("MEDECIN"+i);
                salle.setRoles(role);
                salle.setSpecialite(Specialite.toEnum(i));
                salle.setMontype("MEDECIN");
                salle.setActive(true);
                medecin.save(salle);

        }
    }
}
