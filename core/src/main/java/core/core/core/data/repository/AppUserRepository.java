package core.core.core.data.repository;


import core.core.core.data.entities.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String login);
    AppUser findById(int id);
    Page<AppUser> findByActiveTrue(Pageable pageable);

}
