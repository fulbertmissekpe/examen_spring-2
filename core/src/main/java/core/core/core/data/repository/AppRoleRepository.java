package core.core.core.data.repository;


import core.core.core.data.entities.AppRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findAllById(int i);
    AppRole findByRoleName(String role);
    AppRole getByRoleName(String roleName);

    Page<AppRole> findByActiveTrue(Pageable pageable);
}
