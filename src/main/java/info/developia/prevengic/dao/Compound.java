package info.developia.prevengic.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
