import com.github.javafaker.Faker;
import entity.Project;
import entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

public class App {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Project project = new Project();
        project.setProjectName("American Experience");


        Student student = new Student();
        student.setStudentName(faker.name().name());
        student.setProjectName("Work and Travel");

        session.save(project);
        session.save(student);
       transaction.commit();
       session.close();
    }
}

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

//        Student student = new Student();
//        student.setFirstName(faker.name().firstName());
//        student.setLastName(faker.name().firstName());
//
//        Teacher teacher = new Teacher();
//        teacher.setFirstName(faker.name().firstName());
//        teacher.setLastName(faker.name().lastName());
//        teacher.setCourse("Math");
//        teacher.addStudentToTeacher(student);
//
//        session.save(teacher);
//        transaction.commit();
//
//        session.close();
//    }
//}
