package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true, includeFieldNames=false)

@PrimaryKeyJoinColumn(name = "sharedKey")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Mentor extends Human {
    Double salary;
}
