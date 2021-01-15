package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, includeFieldNames = false)
//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Human {
//
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Human_sequence")
    @SequenceGenerator(initialValue = 269, name = "Human_sequence")
    Long id;
    String name;
}
