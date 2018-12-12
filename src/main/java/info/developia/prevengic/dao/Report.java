package info.developia.prevengic.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Report {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "report")
    private Set<Workarea> workareas;

    @ManyToOne
    private UserDao user;
}
