package info.developia.prevengic.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

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

    private String nce;

    private String cas;

    private String name;

    @ManyToOne
    private ChemicalProfile chemicalProfile;

    @ManyToOne
    private Workarea workarea;

}
