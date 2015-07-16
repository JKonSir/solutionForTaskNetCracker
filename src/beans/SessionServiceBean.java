package beans;

import entity.Student;
import entity.StudentGroup;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gijoe on 7/15/2015.
 */
@Stateless(name = "SessionServiceBeanEJB")
@Transactional(Transactional.TxType.REQUIRED)
public class SessionServiceBean {
    public SessionServiceBean() {
    }

    public void add(Student student) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }

    public void delete(int index) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, index);
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }

    public void update(int index, Student newStudent) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, index);
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setGroupNumber(newStudent.getGroupNumber());
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }

    public Student findById(int index) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, index);
        entityManager.close();
        managerFactory.close();
        return student;
    }

    public List<Student> findByCriterion(String criterion) {
//        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentGroupUnit");
//        EntityManager entityManager = managerFactory.createEntityManager();
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
//        Query query = entityManager.createNativeQuery("select s from Student s, StudentGroup sg where lower(s.firstName) like " + criterion + "or lower(s.lastName) like " + criterion + "or lower(sg.facultyname) like " + criterion + "or s.idstudent like " + criterion);
//        TypedQuery<StudentGroup> queryGroup = entityManager.createQuery("select sg from StudentGroup sg where sg.groupNumber like " + criterion, StudentGroup.class);
//        int first = queryGroup.getFirstResult();
//        ArrayList<StudentGroup> studentGroups = new ArrayList<>(queryGroup.getResultList());
//        StudentGroup studentGroup;
//        List<Student> students;
//        try {
//            studentGroup = queryGroup.getSingleResult();
////            studentGroup = queryGroup.getResultList();
//        } catch (NoResultException ex) {
//            System.out.println(ex);
//            studentGroup = null;
//        } catch (NonUniqueResultException ex) {
//            System.out.println(ex);
//            studentGroup = null;
//        }
//        if (studentGroup == null) {
//            TypedQuery<Student> query = entityManager1.createQuery("select s from Student s where lower(s.firstName) like " + criterion + " or lower(s.lastName) like " + criterion, Student.class);
////        query.setParameter(criterion, criterion);
//            students = query.getResultList();
//        } else {
////            System.out.println("=================================================================================");
//////        System.out.println(studentGroups.get(0).getIdGroup());
////            System.out.println(studentGroup.getIdGroup());
//////            System.out.println(queryGroup);
////            System.out.println("=================================================================================");
//            TypedQuery<Student> query = entityManager1.createQuery("select s from Student s where lower(s.firstName) like " + criterion + " or lower(s.lastName) like " + criterion + " or s.groupNumber = " + studentGroup.getGroupNumber(), Student.class);
////        query.setParameter(criterion, criterion);
//            students = query.getResultList();
//        }

//        List<StudentGroup> studentGroups = queryGroup.getResultList();
//        List<Student> students = new ArrayList<>();
//        for (int i = 0; i < studentGroups.size(); i++) {
//            TypedQuery<Student> query = entityManager1.createQuery("select s from Student s where (lower(s.firstName) like " + criterion + " or lower(s.lastName) like " + criterion + ") and (s.groupNumber =  '" + studentGroups.get(i).getGroupNumber() + "')", Student.class);
//            students.addAll(query.getResultList());
//        }

//        Query query1 = entityManager1.createNativeQuery("select student from student full outer join ")

        Query query = entityManager.createQuery("select s FROM Student s where lower(s.firstName) like " + criterion + " or lower(s.lastName) like " + criterion + " or s.groupNumber like " + criterion);
        List<Student> students = query.getResultList();

        entityManager.close();
        managerFactory.close();
//        entityManager.close();
//        managerFactory.close();
        return students;
    }

    public List<StudentGroup> getStudentGroups(){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("StudentGroupUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        List<StudentGroup> studentGroups = entityManager.createQuery("select sg from StudentGroup sg").getResultList();
        entityManager.close();
        managerFactory.close();
        return studentGroups;
    }
}
