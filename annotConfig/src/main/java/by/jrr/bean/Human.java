package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, includeFieldNames = false)
//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Human {
//
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Human_sequence")
    @SequenceGenerator(initialValue = 269, name = "Human_sequence")
    Long id;
    String name;

    @OneToMany(cascade = CascadeType.ALL )
    List<Student> studentList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL )
    List<Alumnus> alumnusList = new ArrayList<>();
}
