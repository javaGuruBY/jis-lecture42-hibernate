package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "sharedKey")
public class Alumnus extends Student{
    boolean isHired;

    //    @Transient
    @OneToOne(cascade = CascadeType.ALL)//, fetch = FetchType.LAZY)
    @JoinColumn(name = "piiDatapiiData", referencedColumnName = "id")
    AlumnusPIIData piiData;

    String nickName;

    @ManyToMany
    Human human;

    public Alumnus(String gitHub, String nickName) {
        super(gitHub);
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Alumnus{}";
    }
}
