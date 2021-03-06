package pl.ms.SafeDriving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ms.SafeDriving.model.user.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}
