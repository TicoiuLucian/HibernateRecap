import com.github.javafaker.Faker;
import entity.Student;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.Random;

public class App {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Address address = new Address(faker.address().streetAddress(),
//                faker.address().streetAddressNumber());
//        address.addStudentToAddress(new Student(faker.name().firstName(), faker.name().lastName()));
//        address.addStudentToAddress(new Student(faker.name().firstName(), faker.name().lastName()));
//        address.addStudentToAddress(new Student(faker.name().firstName(), faker.name().lastName()));
//        address.addStudentToAddress(new Student(faker.name().firstName(), faker.name().lastName()));
//        address.addStudentToAddress(new Student(faker.name().firstName(), faker.name().lastName()));
//        address.addStudentToAddress(new Student(faker.name().firstName(), faker.name().lastName()));
//
//
//        transaction.commit();
//        session.save(address);

        Student student1 = new Student();
        student1.setFirstName(faker.name().firstName());
        student1.setLastName(faker.name().firstName());
        float mark1 = (float)(Math.random())*(10);
        student1.setMark(mark1);

        Student student2 = new Student();
        student2.setFirstName(faker.name().firstName());
        student2.setLastName(faker.name().firstName());
        float mark2 = (float)(Math.random())*(10);
        student2.setMark(mark2);

        Student student3 = new Student();
        student3.setFirstName(faker.name().firstName());
        student3.setLastName(faker.name().firstName());
        float mark3 = (float)(Math.random())*(10);
        student3.setMark(mark3);

        Teacher teacher1 = new Teacher();
        teacher1.setFirstName(faker.name().firstName());
        teacher1.setLastName(faker.name().lastName());
        teacher1.setCourse("Math");
        teacher1.addStudentToTeacher(student1);

        Teacher teacher2 = new Teacher();
        teacher2.setFirstName(faker.name().firstName());
        teacher2.setLastName(faker.name().lastName());
        teacher2.setCourse("Chineeze");
        teacher2.addStudentToTeacher(student1);
        teacher2.addStudentToTeacher(student2);
        teacher2.addStudentToTeacher(student3);

        Teacher teacher3 = new Teacher();
        teacher3.setFirstName(faker.name().firstName());
        teacher3.setLastName(faker.name().lastName());
        teacher3.setCourse("CIA");
        teacher3.addStudentToTeacher(student1);


        session.save(student1);
        session.save(student2);
        session.save(student3);
        transaction.commit();

        session.close();
    }
}
