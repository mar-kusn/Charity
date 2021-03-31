package pl.coderslab.institution;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, message = "min 2 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    public Institution() {
    }

    public Institution(@NotNull @Size(min = 2, message = "min 2 characters") String name,
                       @NotNull String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Institution setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Institution setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Institution setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
