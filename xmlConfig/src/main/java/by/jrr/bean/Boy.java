package by.jrr.bean;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Boy {
    Integer id;
    String boy;
    String boyName;
    String boyLastName;
    String login;
    Timestamp timestamp;
}
