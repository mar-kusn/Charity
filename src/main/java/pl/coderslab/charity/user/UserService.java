package pl.coderslab.charity.user;

public interface UserService {
    User findByUsername(String username);

    void saveUser(User user);

    User findByEmail(String email);
}
