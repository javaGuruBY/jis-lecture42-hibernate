package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, includeFieldNames = false)
@PrimaryKeyJoinColumn(name = "sharedKey")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Mentor extends Human {
    Double salary;

//    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany
    List<Student> studentList = new ArrayList<>();
    @ManyToMany
    List<Alumnus> alumnusList = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "MentorDataJoinTable",
            joinColumns =
                    {@JoinColumn(name = "mentor_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "id", referencedColumnName = "mentorPIIData_id")})
    MentorPIIData mentorPIIData;


    @Override
    public String toString() {
        return "Mentor{}";
    }
}
