package pl.coderslab.charity.user;

public interface UserService {
    User findByUserName(String username);

    void saveUser(User user);
}
