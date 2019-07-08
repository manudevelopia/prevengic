package info.developia.prevengic.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "CHEMICAL_PROFILES")
public class ChemicalProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    private Double vlaEdPpm;
    private Double vlaEdMgm;

    private Double vlaEcPpm;
    private Double vlaEcMgm;

    @OneToMany(mappedBy = "chemicalProfile")
    private Set<Compound> compounds;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<WarningAdvice> warningAdvices;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Note> notes;

}
