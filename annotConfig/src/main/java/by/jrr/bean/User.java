package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, includeFieldNames = false)
//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
//
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Human_sequence")
    @SequenceGenerator(initialValue = 69, name = "Human_sequence", allocationSize = 1)
    Long id;
    String userName;
}
//    Hibernate sequence gets multiplied by 50 for `@Id` generation?
//https://stackoverflow.com/questions/34989290/hibernate-sequence-gets-multiplied-by-50-for-id-generation
