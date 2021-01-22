package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentPIIData {
    @Id
    Long id;
    String data;
    @OneToOne
    @MapsId
    Student student;

    @Override
    public String toString() {
        return "StudentPIIData{}";
    }
}
