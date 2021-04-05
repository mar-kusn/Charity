package pl.coderslab.charity.donation;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Institution institution;

    @NotBlank(message = "Street name cannot be empty")
    @Column(name = "street")
    private String street;

    @NotBlank(message = "City name cannot be empty")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Zip code cannot be empty")
    @Column(name = "zip_code")
    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "pick_up_date")
    private LocalDate pickUpDate;

    @DateTimeFormat(pattern = "H:mm")
    @Column(name = "pick_up_time")
    private LocalTime pickUpTime;

    @Size(max = 255, message = "Pick up comment should have maximum 255 characters")
    @Column(name = "pick_up_comment", columnDefinition = "varchar(255) default ''")
    private String pickUpComment;

    public Donation() {
    }

    public Donation(@Size(min = 1) Integer quantity,
                    List<Category> categories,
                    Institution institution,
                    @NotBlank(message = "Street name cannot be empty") String street,
                    @NotBlank(message = "City name cannot be empty") String city,
                    @NotBlank(message = "Zip code cannot be empty") String zipCode,
                    LocalDate pickUpDate,
                    LocalTime pickUpTime,
                    @Size(max = 255, message = "Pick up comment should have maximum 255 characters") String pickUpComment) {
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }

    public Long getId() {
        return id;
    }

    public Donation setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Donation setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Donation setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Donation setInstitution(Institution institution) {
        this.institution = institution;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Donation setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Donation setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Donation setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public Donation setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
        return this;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public Donation setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
        return this;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public Donation setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
        return this;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", categories=" + categories +
                ", institution=" + institution +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", pickUpTime=" + pickUpTime +
                ", pickUpComment='" + pickUpComment + '\'' +
                '}';
    }
}
