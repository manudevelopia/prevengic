package info.developia.prevengic.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COMPOUNDS")
public class Compound {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

}
