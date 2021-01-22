package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AlumnusPIIData {
    @Id
    @GeneratedValue
    Long id;
    String data;
    @OneToOne(mappedBy = "piiData")
    Alumnus alumnus;

    @Override
    public String toString() {
        return "AlumnusPIIData{}";
    }
}
