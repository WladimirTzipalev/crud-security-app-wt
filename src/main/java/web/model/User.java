package web.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "The user name must be specified in the [name] field.")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "The user surname must be specified in the [surname] field.")
    private String surname;

    @Column(name = "age")
    @NotNull(message = "The user age must be specified in the [age] field.")
    @Min(value = 1, message = "The specified age must not be less than 1.")
    @Max(value = 127, message = "The specified age must not be more than 1.")
    private Byte age;

    public User() {}

    public User(String name, String surname, Byte age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
