import com.github.javafaker.Faker;
import entity.Student;
import entity.Teacher;
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

        Student student = new Student();
        student.setFirstName(faker.name().firstName());
        student.setLastName(faker.name().firstName());

        Student student2 = new Student();
        student2.setFirstName(faker.name().firstName());
        student2.setLastName(faker.name().lastName());

        Teacher teacher = new Teacher();
        teacher.setFirstName(faker.name().firstName());
        teacher.setLastName(faker.name().lastName());
        teacher.setCourse("Math");
        teacher.addStudentToTeacher(student);

        Teacher teacher2 = new Teacher();
        teacher.setFirstName(faker.name().firstName());
        teacher.setLastName(faker.name().lastName());
        teacher.setCourse("English");
        teacher.addStudentToTeacher(student2);

        session.save(teacher);
        transaction.commit();

        session.close();
    }
}
