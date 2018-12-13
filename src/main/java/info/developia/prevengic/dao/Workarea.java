package info.developia.prevengic.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "WORKAREAS")
public class Workarea {

    @Id
    private Long id;

    private String name;

    @OneToOne
    private Report report;

    @OneToMany(mappedBy = "workarea")
    private Set<Compound> compounds;

}
