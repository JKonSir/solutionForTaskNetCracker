package beans;

import entity.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by gijoe on 7/15/2015.
 */
@Stateless(name = "SessionServiceBeanEJB")
@Transactional(Transactional.TxType.REQUIRED)
public class SessionServiceBean {
    public SessionServiceBean() {
    }

    public void add(Student student){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Student> findAll() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
//        String query = "select s from student s";
        TypedQuery<Student> query = entityManager.createQuery("SELECT s from Student s ", Student.class);
        List<Student> students = query.getResultList();
//        List<Student> students = entityManager.createQuery(query).getResultList();
//        entityManager.close();
        return students;
    }

    public void delete(int index){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, index);
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        }catch (IllegalArgumentException ex){
            System.out.println("Entity is null");
        }finally {
            entityManager.close();
        }
    }
}
