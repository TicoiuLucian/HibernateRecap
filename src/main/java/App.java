import com.github.javafaker.Faker;
import entity.Notebook;
import entity.Pen;
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

        //Student student = new Student();
        //student.setFirstName(faker.name().firstName());
       // student.setLastName(faker.name().firstName());

       // Teacher teacher = new Teacher();
       // teacher.setFirstName(faker.name().firstName());
       // teacher.setLastName(faker.name().lastName());
      //  teacher.setCourse("Math");
       // teacher.addStudentToTeacher(student);

       // session.save(teacher);
        Student student = new Student();
        student.setFirstName(faker.name().firstName());
        student.setLastName(faker.name().lastName());
        student.setCourse("Math");

        Student student2 = new Student();
        student2.setFirstName(faker.name().firstName());
        student2.setLastName(faker.name().lastName());

        Teacher teacher = new Teacher();
        teacher.setFirstName(faker.name().firstName());
        teacher.setLastName(faker.name().lastName());
        teacher.setCourse("History");




        Pen pen = new Pen();
        pen.setColor("Blue");
        pen.setType("fontain pen");

        Notebook notebook = new Notebook();
        notebook.setType("A4");
        notebook.setForWhichCourse("Math");

        Student student1 = new Student();
        student1.setFirstName(faker.name().firstName());
        student1.setLastName(faker.name().lastName());

        session.save(student);

        Teacher teacher2 = new Teacher();
        teacher.setFirstName(faker.name().firstName());
        teacher.setLastName(faker.name().lastName());
        teacher.setCourse("English");
        teacher.addStudentToTeacher(student2);


        session.save(teacher);
        session.save(notebook);
        session.save(pen);

        transaction.commit();

        session.close();
    }
}
