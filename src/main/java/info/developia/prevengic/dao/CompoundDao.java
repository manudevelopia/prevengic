package info.developia.prevengic.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
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
public class CompoundDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    private String nce;

    private String ncas;

    private String name;

    private String url;

    @ManyToOne(cascade = CascadeType.ALL)
    private ChemicalProfileDao chemicalProfile;

    @ManyToOne(cascade = CascadeType.ALL)
    private WorkareaDao workarea;

}
