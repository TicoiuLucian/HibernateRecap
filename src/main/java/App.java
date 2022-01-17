import com.github.javafaker.Faker;
import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class App {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Student> students = new ArrayList<>();
        students.add(new Student(faker.name().firstName(), faker.name().lastName()));
        students.add(new Student(faker.name().firstName(), faker.name().lastName()));
        students.add(new Student(faker.name().firstName(), faker.name().lastName()));
        students.add(new Student(faker.name().firstName(), faker.name().lastName()));
        students.add(new Student(faker.name().firstName(), faker.name().lastName()));
        students.add(new Student(faker.name().firstName(), faker.name().lastName()));

        Address address = new Address(faker.address().streetAddress(),
                faker.address().streetAddressNumber(), students);

        transaction.commit();
        session.save(address);

        session.close();


        session = sessionFactory.openSession();
        System.out.println(session.get(Address.class, 1L));
    }
}
