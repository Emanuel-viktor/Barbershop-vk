package barbershop_vk.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Service {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int duration;

    public Service() {
    }

    public Service(String name, int id, String description, BigDecimal price, int duration) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id == service.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
