package info.developia.prevengic.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class ChemicalProfile {

    @Id
    private Long id;

    private String prop1;

    @OneToMany(mappedBy = "chemicalProfile")
    private Set<Compound> compounds;

}
