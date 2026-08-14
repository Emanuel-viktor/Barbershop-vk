package barbershop_vk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Setter
@Getter
@Entity
@Table(name = "tb_users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String telephone;

    @OneToMany(mappedBy = "client")
    private List<Scheduling> schedulings;

    public User() {
    }

    public User(Long id, String name, String email, String password, String telephone, List<Scheduling> schedulings ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.schedulings = schedulings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
