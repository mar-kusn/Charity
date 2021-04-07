package pl.coderslab.charity.institution;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255, message = "Pick up comment should have maximum 255 characters")
    @Column(name = "description", columnDefinition = "varchar(255) default ''")
    private String description;

    public Institution() {
    }

    public Institution(@NotBlank(message = "Name cannot be empty") String name,
                       @Size(max = 255, message = "Pick up comment should have maximum 255 characters") String description) {
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
