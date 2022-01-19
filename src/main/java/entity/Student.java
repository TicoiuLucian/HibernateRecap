package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends  Person{

private float lastYearAverageMark;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "Student_Address",
//            joinColumns = @JoinColumn(name = "Student_ID"),
//            inverseJoinColumns = @JoinColumn(name = "Address_id"))
//    private Address address;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
    private List<Teacher> teachers = new ArrayList<>();

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addTeacherToStudent(Teacher teacher) {
        teachers.add(teacher);
    }

    public void setMark (float mark){
        this.lastYearAverageMark = mark;
    }
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", address=" + address.getStreet() + " no." + address.getNumber() +
//                '}';
//    }
}
