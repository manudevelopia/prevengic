package info.developia.prevengic.dao;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "WARNING_ADVICES")
public class WarningAdvice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @UniqueElements
    private String code;

    private String description;

    @ManyToMany
    private Set<ChemicalProfile> chemicalProfiles;
}
