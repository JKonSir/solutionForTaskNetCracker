package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by gijoe on 7/16/2015.
 */

@Entity
public class StudentGroup {

    @Id
    private int idGroup;
    private String groupNumber;

    public StudentGroup() {
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public int getIdGroup() {
        return idGroup;
    }
}
