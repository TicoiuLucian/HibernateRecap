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

        Student student1 = new Student();
        student1.setFirstName(faker.name().firstName());
        student1.setLastName(faker.name().firstName());
        float mark1 = (float) (Math.random()) * (10);
        student1.setMark(mark1);

        Student student2 = new Student();
        student2.setFirstName(faker.name().firstName());
        student2.setLastName(faker.name().firstName());
        float mark2 = (float) (Math.random()) * (10);
        student2.setMark(mark2);

        Teacher teacher = new Teacher();
        teacher.setFirstName(faker.name().firstName());
        teacher.setLastName(faker.name().lastName());
        teacher.setCourse("Math");
        teacher.addStudentToTeacher(student1);

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

        Teacher teacher3 = new Teacher();
        teacher3.setFirstName(faker.name().firstName());
        teacher3.setLastName(faker.name().lastName());
        teacher3.setCourse("CIA");
        teacher3.addStudentToTeacher(student1);

        Pen pen = new Pen();
        pen.setColor("Blue");
        pen.setType("fontain pen");

        Notebook notebook = new Notebook();
        notebook.setType("A4");
        notebook.setForWhichCourse("Math");

        session.save(student1);
        session.save(student2);
        transaction.commit();


        session.save(teacher);
        session.save(notebook);
        session.save(pen);

        transaction.commit();

        session.close();
    }
}
