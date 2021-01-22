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

    @Override
    public String toString() {
        return "Alumnus{}";
    }
}
