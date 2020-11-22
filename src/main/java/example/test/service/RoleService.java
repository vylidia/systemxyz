package example.test.service;

import example.test.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);

    Role findByName(String role);

    List<Role> findAll();
}
