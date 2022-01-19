package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Pen")
public class Pen extends Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pen_ID")
    private long id;

    @Column(name = "Color_Type")
    private String color;

    @Column(name = "Type_Pen")
    private String type;

}
