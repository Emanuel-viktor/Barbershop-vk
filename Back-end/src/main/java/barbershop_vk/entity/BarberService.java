package barbershop_vk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
@Setter
@Getter
@Entity
@Table(name = "tb_barberService")
public class BarberService implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int duration;
    @OneToMany(mappedBy = "service")
    private List<Scheduling> schedulings;

    public BarberService() {
    }

    public BarberService(String name, Long id, String description, BigDecimal price, int duration) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BarberService service = (BarberService) o;
        return id == service.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
