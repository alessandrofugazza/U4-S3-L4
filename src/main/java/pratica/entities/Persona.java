package pratica.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "people")
public class Persona {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Persona() {
    }

    public Persona(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}