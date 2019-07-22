package info.developia.prevengic.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "WORKAREAS")
public class WorkareaDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    private String name;

    @OneToOne
    private ReportDao report;

    @OneToMany(mappedBy = "workarea")
    private Set<Compound> compounds;

}
