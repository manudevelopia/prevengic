package info.developia.prevengic.dao;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class Note {

    @Id
    @UniqueElements
    private String code;

    private String description;

    @ManyToMany
    private Set<ChemicalProfile> chemicalProfiles;
    
}
