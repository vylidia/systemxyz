package example.test.service;

import example.test.model.Role;
import example.test.model.User;

import java.util.HashSet;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
