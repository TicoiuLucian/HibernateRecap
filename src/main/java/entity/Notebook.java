package entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "Notebook")
public class Notebook extends Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Notebook_ID")
    private long id;

    @Column(name = "Notebook_Format")
    private String type;

    @Column(name = "For_Which_Course")
    private String forWhichCourse;

}