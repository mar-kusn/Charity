package pl.coderslab.charity.user;

import pl.coderslab.charity.role.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, message = "min 2 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 2, message = "min 2 characters")
    @Column(name = "last_name")
    private String lastName;

    @Size(min = 5, max = 60, message = "must between 5 and 60")
    @Column(nullable = false, unique = true, length = 60)
    private String username;

    @Email
    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 8, message = "min 8 characters")
    private String password;

    @Transient
    private String password2;

    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPassword2() {
        return password2;
    }

    public User setPassword2(String password2) {
        this.password2 = password2;
        return this;
    }

    public int getEnabled() {
        return enabled;
    }

    public User setEnabled(int enabled) {
        this.enabled = enabled;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
