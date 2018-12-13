package info.developia.prevengic.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "CHEMICAL_PROFILES")
public class ChemicalProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double vlaEdPpm;
    private Double vlaEdMgm;

    private Double vlaEcPpm;
    private Double vlaEcMgm;

    @OneToMany(mappedBy = "chemicalProfile")
    private Set<Compound> compounds;

    @ManyToMany
    private Set<WarningAdvice> warningAdvices;

    @ManyToMany
    private Set<Note> notes;

}
