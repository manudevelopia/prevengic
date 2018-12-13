package info.developia.prevengic.dao;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Compound {

    @Id
    @UniqueElements
    private String nce;

    @UniqueElements
    private String cas;

    @UniqueElements
    private String name;

    @ManyToOne
    private ChemicalProfile chemicalProfile;

    @ManyToOne
    private Workarea workarea;

    @ManyToMany
    private Set<WarningAdvice> warningAdvices;

}
