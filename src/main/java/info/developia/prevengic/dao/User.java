package info.developia.prevengic.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    private String email;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Report> reports;

}
