package info.developia.prevengic.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Data
@Entity
public class Workarea {

    @Id
    private Long id;

    private String name;

    @OneToOne
    private Report report;

    @OneToMany(mappedBy = "workarea")
    private Set<Compound> compounds;

}
