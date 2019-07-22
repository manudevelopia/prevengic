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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CHEMICAL_PROFILES")
public class ChemicalProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    private Double vlaEdPpm;
    private Double vlaEdMgm;

    private Double vlaEcPpm;
    private Double vlaEcMgm;

    @OneToMany(mappedBy = "chemicalProfile")
    private Set<Compound> compounds;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<WarningAdviceDao> warningAdvices;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<NoteDao> notes;

    public void addNote(NoteDao note) {
        if (notes == null) {
            notes = new HashSet<>();
        }

        notes.add(note);
    }

    public void addWarningAdvice(WarningAdviceDao warningAdvice) {
        if (warningAdvices == null) {
            warningAdvices = new HashSet<>();
        }

        warningAdvices.add(warningAdvice);
    }

}
