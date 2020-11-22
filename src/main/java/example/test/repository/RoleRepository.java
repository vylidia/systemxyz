package example.test.repository;

import example.test.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>{
    List<Role> findAll();

    Role findByName(String role);
}
