package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;

    private String number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private List<Student> students = new ArrayList<>();

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public void addStudentToAddress(Student student) {
        this.students.add(student); //am adaugat studentul in camin (s-a actualizat caminul)
        student.setAddress(this); //am adaugat adresa la student (s-a actualizat studentul, acum stie unde sta)
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", students=" + students +
                '}';
    }
}
