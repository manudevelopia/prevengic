package info.developia.prevengic.dao;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email(regexp = ".+@.+\\..+|")
    private String email;

    @NotEmpty
    @Pattern(regexp = "[^0-9]") // not number allowed
    private String name;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Report> reports;

}
