package info.developia.prevengic.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Email(regexp = ".+@.+\\..+|")
    private String email;

    @NotEmpty
    private String name;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Report> reports;

}
