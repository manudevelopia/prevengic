package info.developia.prevengic.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ChemicalProfile {

    private String prop1;

    private Set<Compound> compounds;

}
