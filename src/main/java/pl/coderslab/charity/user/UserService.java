package pl.coderslab.charity.user;

public interface UserService {
    User findByUsername(String username);

    void addUser(User user);

    User findByEmail(String email);

    boolean existsByName(String username);

    boolean existsByEmail(String email);
}
