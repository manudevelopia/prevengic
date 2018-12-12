package info.developia.prevengic.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private String email;
    private String username;
    private String password;

//    private Set<Report> reports;

}
