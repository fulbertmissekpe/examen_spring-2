package core.core.core.data.Fixtures;

import core.core.core.data.entities.AppRole;
import core.core.core.data.entities.AppUser;
import core.core.core.data.repository.AppRoleRepository;
import core.core.core.data.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@Order(2)
@RequiredArgsConstructor
public class UserFixtures implements CommandLineRunner {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        List<AppRole> role=new ArrayList<>();


        //List<AppUser> user=new ArrayList<>();
        // user.add((AppUser)role.get(0).getUsers());
        role.add(appRoleRepository.findAllById(4));
        for (int i = 1; i < 4; i++) {
            AppUser ac =new AppUser();
            ac.setNom("nom"+i);
            ac.setPassword(passwordEncoder.encode("passer"));
            ac.setPrenom("prenom"+i);
            ac.setUsername("ADMIN"+i);
            ac.setRoles(role);
            ac.setMontype("ADMIN");
            ac.setActive(true);
            appUserRepository.save(ac);
        }
    }
}
