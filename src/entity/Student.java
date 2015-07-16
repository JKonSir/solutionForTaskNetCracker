package entity;

import javax.persistence.*;

/**
 * Created by gijoe on 7/15/2015.
 */
@Entity
//@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idStudent;
    private String firstName;
    private String lastName;
    private String groupNumber;

    public Student() {
    }

    public Student(int idStudent, String firstName, String lastName, String groupNumber) {
        this.idStudent = idStudent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNumber = groupNumber;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String idGroup) {
        this.groupNumber = idGroup;
    }
}
