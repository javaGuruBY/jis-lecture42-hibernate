package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true, includeFieldNames=false)

@PrimaryKeyJoinColumn(name = "sharedKey")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Mentor extends Human {
    Double salary;

    @OneToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    List<Student> studentList = new ArrayList<>();
}
