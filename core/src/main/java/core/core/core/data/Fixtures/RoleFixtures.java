package core.core.core.data.Fixtures;


import core.core.core.data.entities.AppRole;
import core.core.core.data.entities.AppUser;
import core.core.core.data.repository.AppRoleRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@Order(value = 1)
@RequiredArgsConstructor
public class RoleFixtures implements CommandLineRunner {
    private final AppRoleRepository appRoleRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 5; i++) {
            AppRole role=new AppRole();
           role.setActive(true);
            List<AppUser> users=new ArrayList<>();
            //role.setUsers(users);
            if (i==1){
                role.setRoleName("MEDECIN");
            }
            if (i==2){
                role.setRoleName("PATIENT");
            }
            if (i==3){
                role.setRoleName("SECRETAIRE");
            }
            if (i==4){
                role.setRoleName("ADMIN");
            }
            appRoleRepository.save(role);
        }
    }
}
