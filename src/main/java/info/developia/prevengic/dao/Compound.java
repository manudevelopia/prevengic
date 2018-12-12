package info.developia.prevengic.dao;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Compound {

    @Id
    @UniqueElements
    private String code;

    @UniqueElements
    private String name;

    @ManyToOne
    private ChemicalProfile chemicalProfile;

    @ManyToOne
    private Workarea workarea;

}
