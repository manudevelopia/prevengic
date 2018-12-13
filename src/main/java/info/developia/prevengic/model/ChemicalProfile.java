package info.developia.prevengic.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ChemicalProfile {

    private Double vlaEdPpm;
    private Double vlaEdMgm;

    private Double vlaEcPpm;
    private Double vlaEcMgm;

    private Set<String> notes;
    private Set<String> dangerNotes;

    private Set<Compound> compounds;

}
