package entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String course;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "teachers_students",
            joinColumns = @JoinColumn(name = "Teacher_ID"),
            inverseJoinColumns = @JoinColumn(name = "Student_ID"))
    private List<Student> students = new ArrayList<>();

    public void addStudentToTeacher(Student student) {
        students.add(student);
        student.addTeacherToStudent(this);
    }

}
