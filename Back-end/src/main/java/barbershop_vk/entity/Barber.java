package barbershop_vk.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Entity
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String telephone;
    private String description;

    @OneToMany(mappedBy = "barber")
    private List<Scheduling> schedulings;

    public Barber() {
    }

    public Barber(Long id, String name, String email, String password, String telephone, String description, List<Scheduling> schedulings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.description = description;
        this.schedulings = schedulings;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Scheduling> getSchedulings() {
        return schedulings;
    }

    public void setSchedulings(List<Scheduling> schedulings) {
        this.schedulings = schedulings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Barber barber = (Barber) o;
        return Objects.equals(id, barber.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
