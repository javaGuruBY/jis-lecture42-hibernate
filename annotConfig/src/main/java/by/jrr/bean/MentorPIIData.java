package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MentorPIIData {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    String data;
    @OneToOne(mappedBy = "mentorPIIData")
    private Mentor mentor;

    @Override
    public String toString() {
        return "MentorPIIData{}";
    }
}
