package by.jrr.bean;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "sharedKey")
public class Student extends Human{
    String gitHub;
    @OneToOne
    StudentPIIData studentPIIData;

    @ManyToOne
    Human human;

    public Student(String gitHub) {
        this.gitHub = gitHub;
    }

    @Override
    public String toString() {
        return "Student{}";
    }


}
